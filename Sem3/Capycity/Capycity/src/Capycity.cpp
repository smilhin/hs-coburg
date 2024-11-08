#include "Capycity.h"


Capycity::Capycity(const int& length, const int& width)
	: _length(length), _width(width)
{}

void Capycity::Run()
{

	Build** build_area = Capycity::CreateArray();
	InitArray(build_area);

	while (true)
	{
		char choice;
		Build art;
		int build_length, build_width, build_position;

		std::cout << "Choose a function (G, L, A, E): ";
		std::cin >> choice;

		if (choice == 'G')
		{
			std::cout << "Art (0, 1, 2, 3): ";
			std::cin >> art;
			
			std::cout << "Laenge: ";
			std::cin >> build_length;

			std::cout << "Breite: ";
			std::cin >> build_width;

			std::cout << "Position: ";
			std::cin >> build_position;

			if (CheckPlace(build_area, build_position, build_length, build_width))
			{

				for (int i = build_position; i < (build_position + build_length); i++)
				{
					for (int j = 0; j < build_width; j++)
					{
						build_area[i][j] = art;
						std::cout << build_area[i][j] << " ";
					}
					std::cout << "\n";
				}
			}
			else
			{
				std::cout << "Ungueltige Eingabe >:(\n";
			}

		}
		else if (choice == 'L')
		{
			std::cout << choice << "\n";
		}
		else if (choice == 'A')
		{
			PrintArray(build_area);

		}
		else if (choice == 'E')
		{
			std::cout << choice << "\n";
			break;
		}
		else 
		{
			std::cout << "Ungueltige Eingabe >:(\n";
		}
	}

	Capycity::DeleteArray(build_area);
}


//Array-Funktionen

Build** Capycity::CreateArray()
{

	Build** build_area = new Build* [_length];

	for (int i = 0; i < _length; i++)
	{
		build_area[i] = new Build[_width];
	}

	return build_area;

}

void Capycity::DeleteArray(Build** array)
{

	for (int i = 0; i < _length; ++i) {
		delete[] array[i];
	}

	delete[] array;

}

void Capycity::InitArray(Build** array)
{
	for (int i = 0; i < _length; i++)
	{
		for (int j = 0; j < _width; j++)
		{
			array[i][j] = Build::EMPTY;
		}
	}
}


void Capycity::PrintArray(Build** array)
{
	for (int i = 0; i < _length; i++)
	{
		for (int j = 0; j < _width; j++)
		{
			std::cout << array[i][j] << "   ";
		}
		std::cout << "\n\n";
	}
}

//Prüfiing Kollidierung

bool Capycity::CheckPlace(Build** array, const int& position, const int& length, const int& width)
{

	if (position + length > _length || width > _width) return false;


	for (int i = position; i < (position + length); i++)
	{
		for (int j = 0; j < width; j++)
		{
			if (array[i][j] == 0) continue;
			else return false;
		}
	}

	return true;
}