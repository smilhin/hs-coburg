#include "Building.h"
#pragma once

class Solarpanel : public Building
{
public:
	Solarpanel()
	{
		setName("Solarpanel");
		setPrice(18000);
		std::vector<std::string> material = {"Metall", "Metall" , "Metall" , "Metall" , "Metall" , "Metall"
		"Kunststoff", "Kunststoff", "Kunststoff"
		};
		setMaterials(material);
		
	}
	std::vector<std::string> getMaterials() override
	{
		return materials;
	}

};