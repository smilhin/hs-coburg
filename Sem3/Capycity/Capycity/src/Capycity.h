#pragma once

#include <array>
#include <iostream>

#include "../lib/Building.h"


class Capycity
{
public:

	Capycity(const int& length, const int& width);

	void Run();

	Build** CreateArray();

	void InitArray(Build** array);

	void DeleteArray(Build** array);

	void PrintArray(Build** array);

	bool CheckPlace(Build** array, const int& position, const int& length, const int& width);

private:
	const int _length, _width;

};

