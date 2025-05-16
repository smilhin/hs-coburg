#pragma once
#include <string>
#include <iostream>


class Material 
{
public:

	const std::string getName()
	{
		return _name;
	}
	const int getPrice()
	{
		return _price;
	}

	void setName(const std::string& name)
	{
		_name = name;
	}
	void setPrice(const int& price)
	{
		_price = price;
	}


private:
	std::string _name = "";
	int _price = 0;
};

