#include "Building.h"
#pragma once

class Windkraftwerk : public Building
{
public:
	Windkraftwerk()
	{
		setName("Windkraftwerk");
		setPrice(20000);
		std::vector<std::string> material = { "Holz", "Holz", "Metall", "Metall",
		 "Kunststoff", "Kunststoff", "Kunststoff", "Kunststoff", "Kunststoff"
		};
		setMaterials(material);
	}
	
	std::vector<std::string> getMaterials() override
	{
		return materials;
	}

};