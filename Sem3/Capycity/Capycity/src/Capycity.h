#pragma once

#include <array>
#include <iostream>

#include "../lib/Building.h"


class Capycity
{
public:

	Capycity(const int& length, const int& width);

	void Run();

	Build** CreateArray(const int& length, const int& width);

	void DeleteArray(Build** array, const int& length);

private:
	const int _length, _width;

};

