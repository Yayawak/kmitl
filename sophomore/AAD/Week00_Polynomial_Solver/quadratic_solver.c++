#include <iostream>
#include <string>
#include <math.h>

template <typename T>
T getInput(std::string name)
{
    std::cout << "Enter variable " << name << "\n";
    // float ret;
    T ret;
    std::cin >> ret;
    return ret;
}

struct Solutions
{
    float X[2];

    void printX()
    {
        printf("x1 = %f\n", X[0]);
        printf("x2 = %f\n", X[1]);
    }
};

struct Solutions solver(float A, float B, float C)
{
    struct Solutions sol;
    

    printf("solving\n");
    printf("%.2fx^2 + %.2fx + %.2f = 0\n", A, B, C);
    if (A == 0) //* reduce to linear equation
    {
        printf("This Equation is linear equation -> reduced to easy.\n");
        // Bx + c = 0
        // x = -C / B;
        sol.X[0] = -C / B;
        printf("X = %f", sol.X[0]);
    }
    else // * normal quadratic equation 
    {
        // This value will be on square root so we check 3 case lol +, -, 0
        float discriminant = (B * B) - (4 * A * C);
        printf("discriminant = %f\n", discriminant);
        if (discriminant > 0)
        {
            // ? long formular -> normal way
            float doubleA = 2 * A;
            float term2 = sqrt(discriminant) / doubleA;
            float term1 = (-1 * B) / doubleA;
            // float x1 = term1 + term2;
            // float x2 = term1 - term2;
            sol.X[0] = term1 + term2;
            sol.X[1] = term1 - term2;
            printf("This equation has 2 solutions\n");
            printf("X1 = %f\n", sol.X[0]);
            printf("X2 = %f\n", sol.X[1]);
        }
        else if (discriminant == 0)
        {
            // float x = (-1 * B) / (2 * A);
            sol.X[0] = (-1 * B) / (2 * A);
            printf("X = %f\n", sol.X[0]);
        }
        else
        {
            printf("This Equation is complex function Sorry I dont wnat to solve for you now.");
        }
    }
    printf("\n\n");
    // std::cout << A;
    return sol;
}

int main()
{
    float A, B, C;


    // A = getInput("A");
    // B = getInput("B");
    // C = getInput("C");
    A = 0; B = 7; C = 2;

    struct Solutions solutions = solver(A, B, C);

    A = 1;
    solver(A,B,C);

    A = 20;
    solver(A,B,C);
    // solutions.printX();
    
    
    return 0;
}