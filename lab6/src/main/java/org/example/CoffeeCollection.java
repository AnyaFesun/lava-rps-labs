package org.example;

import java.util.*;

/**
 * A class that implements a typed collection that contains objects of type Coffee or its subclasses.
 * This class implements the List interface, using an array to store elements.
 */
public class CoffeeCollection implements List<Coffee> {
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;
    private Object[] elements;
    private int size;

    /**
     * Empty constructor.
     * Initializes an empty array with an initial size of 15.
     */
    public CoffeeCollection() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Constructor that accepts a single object of type Coffee.
     * Creates a collection with a single element.
     *
     * @param coffee The Coffee element to be added to the collection.
     */
    public CoffeeCollection(Coffee coffee) {
        elements = new Object[INITIAL_CAPACITY];
        elements[0] = coffee;
        size = 1;
    }

    /**
     * Constructor that accepts a standard collection.
     * Copies the elements from the passed collection to a new array.
     *
     * @param collection The collection of Coffee elements to copy.
     */
    public CoffeeCollection(Collection<? extends Coffee> collection) {
        elements = collection.toArray();
        size = elements.length;
    }

    /**
     * Returns the number of elements in the collection.
     *
     * @return Number of elements in the collection.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the collection is empty.
     *
     * @return true if the collection is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if a collection contains a specific item.
     *
     * @param o The object to check for in the collection.
     * @return true if the item is in the collection, false otherwise.
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator to iterate over the elements of the collection.
     *
     * @return An iterator to iterate over the elements of the collection.
     */
    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            private int currentIndex = 0;

            /**
             * Checks if the next element exists.
             *
             * @return true if the next element exists, false otherwise.
             */
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            /**
             * Returns the next element.
             *
             * @return The next element.
             * @throws NoSuchElementException If there is no next element.
             */
            @Override
            public Coffee next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (Coffee) elements[currentIndex++];
            }
        };
    }

    /**
     * Returns an array containing all the elements of the collection.
     *
     * @return An array containing the elements of the collection.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Converts a collection to an array of a specific type.
     *
     * @param <T1> The type of array to convert the collection to.
     * @param a The array to which the collection elements will be copied.
     * @return An array with the collection elements.
     */
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Adds an item to the collection.
     *
     * @param t The item to be added to the collection.
     * @return true if the item was successfully added.
     */
    @Override
    public boolean add(Coffee t) {
        ensureCapacity(size + 1);
        elements[size++] = t;
        return true;
    }

    /**
     * Removes the specified element from the collection.
     *
     * @param o The element to be removed.
     * @return true if the element was successfully removed.
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                int numMoved = size - i - 1;
                if (numMoved > 0) {
                    System.arraycopy(elements, i + 1, elements, i, numMoved);
                }
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether a collection contains all the elements from another collection.
     *
     * @param c The collection of elements to check.
     * @return true if the collection contains all the elements from the passed collection.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements from another collection to this collection.
     *
     * @param c The collection of elements to add.
     * @return true if the collection has been modified.
     */
    @Override
    public boolean addAll(Collection<? extends Coffee> c) {
        ensureCapacity(size + c.size());
        for (Coffee t : c) {
            elements[size++] = t;
        }
        return true;
    }

    /**
     * Adds all elements from another collection to the specified position.
     *
     * @param index The position to start adding.
     * @param c The collection of elements to add.
     * @return true if the collection has been modified.
     */
    @Override
    public boolean addAll(int index, Collection<? extends Coffee> c) {
        ensureCapacity(size + c.size());
        System.arraycopy(elements, index, elements, index + c.size(), size - index);
        for (Coffee t : c) {
            elements[index++] = t;
        }
        size += c.size();
        return true;
    }

    /**
     * Removes all items from a collection that belong to another collection.
     *
     * @param c The collection of items to remove.
     * @return true if the collection has been modified.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements that do not belong to the passed collection.
     *
     * @param c Collection of elements that should remain in the collection.
     * @return true if the collection has been modified.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<Coffee> iterator = iterator();
        while (iterator.hasNext()) {
            Coffee element = iterator.next();
            if (!c.contains(element)) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements from the collection.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Returns the element at index.
     *
     * @param index The index of the element.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException If the index is outside the bounds of the collection.
     */
    @Override
    public Coffee get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (Coffee) elements[index];
    }

    /**
     * Replaces the element at the specified index with the new value.
     *
     * @param index The index at which the element will be replaced.
     * @param element The new element that will replace the old one.
     * @return The old element that was replaced.
     * @throws IndexOutOfBoundsException If the index is outside the bounds of the collection.
     */
    @Override
    public Coffee set(int index, Coffee element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Coffee oldValue = (Coffee) elements[index];
        elements[index] = element;
        return oldValue;
    }

    /**
     * Adds an element at the specified position.
     *
     * @param index The index at which the element will be added.
     * @param element The element to be added.
     * @throws IndexOutOfBoundsException If the index is outside the collection bounds.
     */
    @Override
    public void add(int index, Coffee element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index The index of the element to remove.
     * @return The removed element.
     * @throws IndexOutOfBoundsException If the index is outside the collection bounds.
     */
    @Override
    public Coffee remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Coffee oldValue = (Coffee) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }

    /**
     * Sorts the coffee collection using the provided comparator.
     * This method sorts the collection by converting it to an array,
     * sorting the array, and then updating the original collection
     * with the sorted elements.
     *
     * @param comparator The comparator to determine the order of the collection.
     * A null comparator will cause a NullPointerException.
     * @throws NullPointerException If the comparator is null.
     * @throws IllegalStateException If an issue occurs while updating the collection.
     */
    public void sort(Comparator<? super Coffee> comparator) {
        Coffee[] coffeeArray = toArray(new Coffee[0]);
        Arrays.sort(coffeeArray, comparator);
        for (int i = 0; i < coffeeArray.length; i++) {
            this.set(i, coffeeArray[i]);
        }
    }

    /**
     * Checks if the collection contains an element at the specified index.
     *
     * @param o The element to search for.
     * @return The index of the element if found, otherwise -1.
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the index of an element is at the end of the collection.
     *
     * @param o The element to search for.
     * @return The index of the element at the end of the collection, if found.
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks and ensures that the array has enough capacity to add new elements.
     *
     * @param minCapacity Minimum capacity for the array.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = (int) (elements.length * GROWTH_FACTOR);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
    /**
     * Returns a list iterator over the elements in this list in proper sequence.
     *
     * @return A list iterator over the elements in this list.
     * @throws UnsupportedOperationException If the method is not fully implemented yet.
     */
    @Override
    public ListIterator<Coffee> listIterator() {
        return new ListIterator<Coffee>() {
            private int currentIndex = 0;

            /**
             * Checks if there is a next element in the list.
             *
             * @return true if there is a next element, false otherwise.
             */
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            /**
             * Returns the next element in the list.
             *
             * @return The next element in the list.
             * @throws NoSuchElementException If there are no more elements to return.
             */
            @Override
            public Coffee next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (Coffee) elements[currentIndex++];
            }

            /**
             * Checks if there is a previous element in the list.
             *
             * @return true if there is a previous element, false otherwise.
             */
            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            /**
             * Returns the previous element in the list.
             *
             * @return The previous element in the list.
             * @throws NoSuchElementException If there are no more elements to return.
             */
            @Override
            public Coffee previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                return (Coffee) elements[--currentIndex];
            }

            /**
             * Returns the index of the element that would be returned by a call to {@link #next()}.
             *
             * @return The index of the next element.
             */
            @Override
            public int nextIndex() {
                return currentIndex;
            }

            /**
             * Returns the index of the element that would be returned by a call to {@link #previous()}.
             *
             * @return The index of the previous element.
             */
            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            /**
             * Removes the last element returned by {@link #next()} or {@link #previous()}.
             *
             * @throws UnsupportedOperationException If the method is not supported.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            /**
             * Replaces the last element returned by {@link #next()} or {@link #previous()}.
             *
             * @param e The element to replace the last returned element.
             * @throws IllegalStateException If no element is returned yet.
             */
            @Override
            public void set(Coffee e) {
                if (currentIndex < 0 || currentIndex >= size) {
                    throw new IllegalStateException();
                }
                elements[currentIndex] = e;
            }

            /**
             * Inserts a new element into the list.
             *
             * @param e The element to be inserted.
             * @throws UnsupportedOperationException If the method is not supported.
             */
            @Override
            public void add(Coffee e) {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * Returns a list iterator over the elements in this list, starting at the specified position.
     *
     * @param index Index of the first element to be returned from the list iterator.
     * @return A list iterator over the elements in this list, starting at the specified position.
     * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index > size).
     */
    @Override
    public ListIterator<Coffee> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return listIterator();
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive,
     * and toIndex, exclusive.
     *
     * @param fromIndex Low endpoint (inclusive) of the subList.
     * @param toIndex High endpoint (exclusive) of the subList.
     * @return A view of the specified range within this list.
     * @throws UnsupportedOperationException If the method is not implemented.
     */
    @Override
    public List<Coffee> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList() is not implemented.");
    }

}

