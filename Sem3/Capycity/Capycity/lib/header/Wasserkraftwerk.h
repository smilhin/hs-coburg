#include "../header/Building.h"
#pragma once

class Wasserkraftwerk : public Building
{
public:
	Wasserkraftwerk()
	{
		setName("Wasserkraftwerk");
		setPrice(25000);
		std::vector<std::string> material = {"Holz", "Holz" , "Holz" , "Holz" , "Holz",
		"Metall", "Metall", "Metall", "Kunststoff"
		};
		setMaterials(material);
	}

	std::vector<std::string> getMaterials() override
	{
		return materials;
	}


};