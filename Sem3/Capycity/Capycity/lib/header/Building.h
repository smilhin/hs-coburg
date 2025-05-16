#pragma once
#include <iostream>
#include <string>
#include <vector>
#include "Material.h"
#include <map>



class Building
{
public:
	std::vector<std::string> materials = {};

	std::string getName() const
	{
		return _name;
	}
	int getPrice() const
	{
		return _price;
	}
	
	virtual std::vector<std::string> getMaterials()
	{
		return materials;
	}


	void setName(const std::string& name)
	{
		_name = name;
	}
	void setPrice(const int& price)
	{
		_price = price;
	}
	void setMaterials(const std::vector<std::string>& vect)
	{
		for (std::string m : vect)
		{
			materials.emplace_back(m);
		}
	}

private:
	std::string _name = "";
	int _price = 0;
};



std::istream& operator>>(std::istream& is, Building& obj);

std::ostream& operator<<(std::ostream& os, Building& obj);

#include "Holz.h"
#include "Kunststoff.h"
#include "Metall.h"