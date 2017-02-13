#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
int main()
{
    int N;
    cin >> N; cin.ignore();
    
    int myArray[N] = {};
    for (int i = 0; i < N; i++) {
        int Pi;
        cin >> Pi; cin.ignore();
        
        myArray[i] = Pi;
    }
    
     std::vector<int> myVector (myArray, myArray + N);
     
     std::sort (myVector.begin(), myVector.begin() + N);
     
     int difference = 9999;
     for (int i = 1 ; i < N; i++){
        if ( (myVector[i] - myVector[i - 1]) < difference ){
            difference = myVector[i] - myVector[i - 1];    
        }
     }
    // Write an action using cout. DON'T FORGET THE "<< endl"
    // To debug: cerr << "Debug messages..." << endl;

    cout << difference << endl;
}


