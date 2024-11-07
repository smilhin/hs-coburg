#include "Building.h"

std::istream& operator>>(std::istream& is, Build& obj) {
    int tmp;
    if (is >> tmp)
    {
        if (tmp == 0)
        {
            obj = EMPTY;
        }
        else if (tmp == 1)
        {
            obj = WASSERKRAFTWERK;
        }
        else if (tmp == 2)
        {
            obj = WINDKRAFTWERK;
        }
        else if (tmp == 3)
        {
            obj = SOLARPANEL;
        }

    }
    return is;
}

std::ostream& operator<<(std::ostream& os, const Build& obj)
{

    if (obj == 0)
    {
        os << "MT";
    }
    else if (obj == 1)
    {
        os << "WS";
    }
    else if (obj == 2)
    {
        os << "WI";
    }
    else if (obj == 3)
    {
        os << "SO";
    }

    return os;
}