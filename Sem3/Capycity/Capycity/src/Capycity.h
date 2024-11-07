#pragma once

#include <array>
#include <iostream>

#include "../lib/Building.h"


class Capycity
{
public:
	Capycity(const int& length, const int& width);
	void Run();
private:
	const int _length, _width;

};

