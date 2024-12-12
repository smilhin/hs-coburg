#pragma once

#include <array>
#include <iostream>

#include "../lib/header/Building.h"


class Capycity
{
public:

	Capycity(const int& length, const int& width);

	void Run();

	Building** CreateArray();

	void InitArray(Building** array);

	void DeleteArray(Building** array);

	void PrintArray(Building** array);

	void PrintBuildingPlan(Building** array, const std::string& type);

	void PrintMaterials(Building** array);

	bool CheckPlace(Building** array, const int& position1, const int& position2, const int& length, const int& width);

private:
	const int _length, _width;

};
