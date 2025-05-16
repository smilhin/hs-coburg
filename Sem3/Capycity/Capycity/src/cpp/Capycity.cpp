#include "../Capycity.h"


Capycity::Capycity(const int& length, const int& width)
	: _length(length), _width(width)
{}

void Capycity::Run()
{

	Building** build_area = Capycity::CreateArray();
	InitArray(build_area);

	while (true)
	{
		char choice;
		Building art;
		int build_length, build_width, build_position1, build_position2;

		std::cout << "Choose a function (G, L, A, E, M, B): ";
		std::cin >> choice;

		if (choice == 'G')
		{
			std::cout << "Art (1, 2, 3): ";
			std::cin >> art;
			
			std::cout << "Laenge: ";
			std::cin >> build_length;

			std::cout << "Breite: ";
			std::cin >> build_width;

			std::cout << "Position1: ";
			std::cin >> build_position1;

			std::cout << "Position2: ";
			std::cin >> build_position2;

			if (CheckPlace(build_area, build_position1, build_position2, build_length, build_width))
			{

				for (int i = build_position1; i < (build_position1 + build_length); i++)
				{
					for (int j = build_position2; j < build_position2 + build_width; j++)
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
			std::cout << "Laenge: ";
			std::cin >> build_length;

			std::cout << "Breite: ";
			std::cin >> build_width;

			std::cout << "Position1: ";
			std::cin >> build_position1;

			std::cout << "Position2: ";
			std::cin >> build_position2;

			if (build_position1 + build_length > _length || build_position2 + build_width > _width)
			{
				std::cout << "Ungueltige Eingabe>:(\n";
			}
			else
			{
				for (int i = build_position1; i < (build_position1 + build_length); i++)
				{
					for (int j = build_position2; j < build_position2 + build_width; j++)
					{
						build_area[i][j] = Building();
					}
				}
				std::cout << "Bereich geloescht!\n";
			}


		}

		else if (choice == 'M')
		{
			PrintMaterials(build_area);
		}

		else if (choice == 'B')
		{
			std::string str = "";
			std::cout << "Gebaeudetyp eingeben: ";
			std::cin >> str;
			PrintBuildingPlan(build_area, str);
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

Building** Capycity::CreateArray()
{

	Building** build_area = new Building*[_length];

	for (int i = 0; i < _length; i++)
	{
		build_area[i] = new Building[_width];
	}

	return build_area;

}

void Capycity::DeleteArray(Building** array)
{

	for (int i = 0; i < _length; ++i) {
		delete[] array[i];
	}

	delete[] array;

}

void Capycity::InitArray(Building** array)
{
	for (int i = 0; i < _length; i++)
	{
		for (int j = 0; j < _width; j++)
		{
			array[i][j] = Building();
		}
	}
}


void Capycity::PrintArray(Building** array)
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

void Capycity::PrintBuildingPlan(Building** array, const std::string& type)
{
	unsigned short holz = 0;
	unsigned short metall = 0;
	unsigned short kunststoff = 0;
	unsigned short types = 0;

	for (int i = 0; i < _length; i++)
	{
		for (int j = 0; j < _width; j++)
		{
			if (array[i][j].getName() == type)
			{
				types++;
				std::vector<std::string> materials = array[i][j].getMaterials();
				for (int k = 0; k < materials.size(); k++)
				{
					if (materials[k] == "Holz")
					{
						holz++;
					}
					else if (materials[k] == "Metall")
					{
						metall++;
					}
					else if (materials[k] == "Kunststoff")
					{
						kunststoff++;
					}
				}
			}
		}
	}
	std::cout << types << " " << type << " (" << holz << "x Holz, "
		<< metall << " x Metall, "
		<< kunststoff << " x Kunststoff) = "
		<< holz * Holz().getPrice() + metall * Metall().getPrice() + kunststoff * Kunststoff().getPrice() << "\n";
}

void Capycity::PrintMaterials(Building** array)
{
	unsigned short holz = 0;
	unsigned short metall = 0;
	unsigned short kunststoff = 0;
	for (int i = 0; i < _length; i++)
	{
		for (int j = 0; j < _width; j++)
		{
			std::vector<std::string> materials = array[i][j].getMaterials();
			for (int k = 0; k < materials.size(); k++)
			{
					if (materials[k] == "Holz")
					{
						holz++;
					}
					else if (materials[k] == "Metall")
					{
						metall++;
					}
					else if (materials[k] == "Kunststoff")
					{
						kunststoff++;
					}				
			}
		}
	}
	std::cout << "(" << holz << "x Holz, "
		<< metall << " x Metall, "
		<< kunststoff << " x Kunststoff) = "
		<< holz * Holz().getPrice() + metall * Metall().getPrice() + kunststoff * Kunststoff().getPrice() << "\n";
}

//Prüfung Kollidierung

bool Capycity::CheckPlace(Building** array, const int& position1, const int& position2, const int& length, const int& width)
{

	if ((position1 + length) > _length || (position2 + width) > _width) return false;


	for (int i = position1; i < (position1 + length); i++)
	{
		for (int j = position2; j < position2 + width; j++)
		{
			if (array[i][j].getName() == "") continue;
			else return false;
		}
	}

	return true;
}