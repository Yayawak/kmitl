// #include <string>
#include <iostream>
#include <math.h>

using namespace std;

void dec2Bin(int, int);

int main() {
    // dec2Bin(-42);
    dec2Bin(5, 3);
}

void dec2Bin(int X, int regs) {
    // cout << "555" << endl;
    // int X = -42;
    // int X = -42;
    // while (1) {
    // int regs = 8;
    int _X = X;
    for (int i = 0; i < regs; i++) {
        int raw = pow(2, regs - (i + 1));
        int sig = (i == 0) ? -raw : raw;

        // cout << _X << endl;

        // if (_X - sig < sig) {
        //* still on bound
        int y = 0;
        if (sig < _X) {
            y = 1;
            _X = _X - sig;
            if (sig == _X) y = 0; // handle last y
            // cout << "_X = " << _X << endl;
        }
        // cout << "y = " << y << endl;
        cout << y;


        // int y = _X;
        // cout << y << endl;

        // cout << "-----------" << endl;
        // cout << "\n\n";
    }
    cout << endl;

    // }
    // cout << X;
}
