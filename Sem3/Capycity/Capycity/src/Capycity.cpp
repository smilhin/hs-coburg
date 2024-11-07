#include "Capycity.h"


Capycity::Capycity(const int& length, const int& width)
	: _length(length), _width(width)
{}

void Capycity::Run()
{

	Build** build_area = Capycity::CreateArray(_length, _width);

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
		else if (choice == 'L')
		{
			std::cout << choice << "\n";
		}
		else if (choice == 'A')
		{
			std::cout << choice << "\n";

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

	Capycity::DeleteArray(build_area, _length);
}

Build** Capycity::CreateArray(const int& length, const int& width)
{

	Build** build_area = new Build* [length];

	for (int i = 0; i < length; i++)
	{
		build_area[i] = new Build[width];
	}

	return build_area;

}

void Capycity::DeleteArray(Build** array, const int& length)
{

	for (int i = 0; i < length; ++i) {
		delete[] array[i];
	}

	delete[] array;

}