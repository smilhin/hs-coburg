#include "../header/Building.h"
#include "../header/Solarpanel.h"
#include "../header/Wasserkraftwerk.h"
#include "../header/Windkraftwerk.h"





std::istream& operator>>(std::istream& is, Building& obj) {
    int tmp;

    if (is >> tmp)
    {
        if (tmp == 1)
        {
            obj = Wasserkraftwerk();
        }
        else if (tmp == 2)
        {
            obj = Windkraftwerk();
        }
        else if (tmp == 3)
        {
            obj = Solarpanel();
        }

    }
    return is;
}

std::ostream& operator<<(std::ostream& os, Building& obj)
{

    if (obj.getName() == "")
    {
        os << "EM";
    }
    else if (obj.getName() == "Wasserkraftwerk")
    {
        os << "WA";
    }
    else if (obj.getName() == "Windkraftwerk")
    {
        os << "WI";
    }
    else if (obj.getName() == "Solarpanel")
    {
        os << "SO";
    }

    return os;
}