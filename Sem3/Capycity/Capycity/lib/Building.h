#pragma once
#include <iostream>

enum Build
{
	EMPTY = 0, WASSERKRAFTWERK, WINDKRAFTWERK, SOLARPANEL
};



std::istream& operator>>(std::istream& is, Build& obj);

std::ostream& operator<<(std::ostream& os, const Build& obj);