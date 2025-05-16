#include <iostream>
#include <string>
#include <vector>
#include <math.h>

struct Int2
{
	int m_x, m_y;

	Int2(const int& x, const int& y) 
	: m_x(x), m_y(y) {}

	const std::string getInt2()
	{
		return std::to_string(m_x) + ", " + std::to_string(m_y) + "\n";
	}
};

static void bresenham(std::vector<Int2>& vector, const Int2& a, const Int2& b)
{

	int y = a.m_y;
	double m = b.m_y - a.m_y / (double)b.m_x - a.m_x;

	for (int x = a.m_x; x <= b.m_x; x++)
	{
		if (2 * x * (b.m_y - a.m_y) - 2 * y * (b.m_x - a.m_x) >= b.m_x - a.m_x)
		{
			y++;
		}
		vector.emplace_back((Int2(x, y)));

	}
}


int main() {
	Int2 a = Int2(2, 1);
	Int2 b = Int2(6, 3);
	std::vector<Int2> vector;
	vector.reserve(10);

	bresenham(vector, a, b);

	for (auto &k : vector)
	{
		std::cout << k.getInt2();
	}
	

}