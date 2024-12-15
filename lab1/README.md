# Laboratory work 1

## Variant
C5: Variant 4: C = A * B (the matrix product)

C7: Variant 3: int

C11: Variant 2: Calculate the sum of the largest elements of each column of a matrix

## Description
This program performs the following actions:
1. Generates two matrices based on the dimensions entered by the user.
2. Multiplies these matrices.
3. Outputs the resulting matrix.
4. Computes and outputs the sum of the largest elements in each column of the resulting matrix.

## Instructions for starting
1. Clone repository:
   ```bash
   git clone https://github.com/AnyaFesun/lava-rps-labs.git
2. Go to the folder:
    ```bash
   cd path/to/lava-rps-labs/lab1/src/main/java
3. Compile the program:
    ```bash
   javac org/example/Main.java
4. Run the program:
    ```bash
    java org.example.Main

## Using the program
1. The program will ask for the dimensions of two matrices A and B.
   Enter positive integers for each query.
2. The program will check:
* Whether the entered values are positive integers.
* Whether matrix multiplication is possible (the number of columns of matrix A must be equal to the number of rows of matrix B).
3. The program will generate random numbers for the matrices, multiply them, and calculate the sum of the largest elements of each column.
> **Example**
>
> Enter the number of rows of matrix A:r
>
> Error: Enter a positive integer!
> 
> -4
> 
> Error: The number must be positive!
> 
> 3 
> 
> Enter the number of columns of matrix A:3 
> 
> Enter the number of rows of matrix B:3 
> 
> Enter the number of columns of matrix B:3 
> 
> Matrix A:
> 
> 13      3     18 
> 
> 15     47     11 
> 
> 41      8     33 
> 
> Matrix B:
> 
> 37     15     40 
> 
> 20     44     37 
> 
> 18     27     26 
> 
> Matrix C (result of multiplication A * B):
> 
> 865    813   1099 
> 
> 1693   2590   2625 
> 
> 2271   1858   2794 
> 
> The sum of the largest elements of each column of matrix C: 7655

