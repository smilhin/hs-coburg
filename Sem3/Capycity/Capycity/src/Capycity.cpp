#include "Capycity.h"


Capycity::Capycity(const int& length, const int& width)
	: _length(length), _width(width)
{}

void Capycity::Run()
{
	while (true)
	{
		
		char choice;

		std::cout << "Choose a function (G, B, A, E): ";
		std::cin >> choice;

		if (choice == 'G')
		{
			
		}
		else if (choice == 'B')
		{

		}
		else if (choice == 'A')
		{

		}
		else if (choice == 'E')
		{
			break;
		}
		else {

		}
	}
}