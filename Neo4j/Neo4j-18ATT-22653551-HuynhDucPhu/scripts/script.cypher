// IMPORT DATA
LOAD CSV WITH HEADERS FROM "file:///zips.csv" AS row
CREATE (n:Zip {
  city: row.city,
  loc_x: toFloat(row.`loc/x`),
  loc_y: toFloat(row.`loc/y`),
  pop: toInteger(row.pop),
  state: row.state,
  code: toInteger(row.code)
});


//1.	List n nodes
match(n:Zip) return n limit 10
//2.	Create a new node
CREATE (n:Zip {code:12345})
SET n.city = "New York", n.state = "NY"
RETURN n;

//3.	Tìm một node khi biết zip code
MATCH (n:Zip) WHERE n.code = 12345
RETURN n;

//4.	Cập nhật thông tin của một node khi biết zip code
MATCH (n:Zip {code:12345})
SET n.city = "New York 1",
n.state = "NY 1"

MATCH (m:Zip) WHERE m.code = 12345
RETURN m;

//5.	Xóa một node khi biết zip code
MATCH (n:Zip{code:12345}) DELETE n;

MATCH (m:Zip) WHERE m.code = 12345
RETURN m;

//6.	Xóa tất cả các node
MATCH (n:Zip) DELETE n;

match(n:Zip) return n limit 10

//7.	Tìm các node có city là PALMER
MATCH (n:Zip)
WHERE n.city = "PALMER"
RETURN n;

//8.	Tìm các node có dân số >100000
MATCH (n:Zip)
WHERE n.pop > 100000
RETURN n;

//9.	Tìm dân số của thành phố FISHERS ISLAND
MATCH (n:Zip)
WHERE n.city = "FISHERS ISLAND"
WITH n.city AS city, SUM(n.pop) AS total_population
RETURN city, total_population;

//10.	Tìm các thành phố có dân số từ 10 – 50
MATCH (n:Zip)
WITH n.city AS city, SUM(n.pop) AS total_population
WHERE total_population >= 10 AND total_population < 50
RETURN city, total_population;

//11.	Tìm tất cả các city của bang MA có dân số trên 500
MATCH (n:Zip)
  WHERE n.state = "MA"
WITH n.city AS city, SUM(n.pop) AS total_population
  WHERE total_population > 500
RETURN city, total_population;

//12.	Tìm tất cả các bang (không trùng)
MATCH (n:Zip)
RETURN DISTINCT n.state AS state;

//13.	Tính dân số trung bình của mỗi bang
MATCH (n:Zip)
WITH n.state AS state, AVG(n.pop) AS avg_pop
RETURN state, avg_pop;

//14.	Tìm những document của bang 'CT' và thành phố 'WATERBURY'
MATCH (n:Zip)
WHERE n.state = "CT" AND n.city = "WATERBURY"
RETURN n;

//15.	Bang WA có bao nhiêu city (nếu trùng chỉ tính 1 lần)
MATCH (n:Zip)
  WHERE n.state = "WA"
RETURN COUNT(DISTINCT n.city);

//16.	Tổng dân số của từng bang, sắp xếp theo tổng dân số giảm dần
MATCH (n:Zip)
WITH n.state AS state, SUM(n.pop) AS total_pop
RETURN state, total_pop
  ORDER BY total_pop DESC;

//17.	Tìm tất cả các bang có tổng dân số trên 10000000
MATCH (n:Zip)
WITH n.state AS state, SUM(n.pop) AS total_pop
  WHERE total_pop > 10000000
RETURN state, total_pop;

//18.	Tìm các node có dân số lớn (nhỏ) nhất
MATCH (n:Zip)
WITH MAX(n.pop) AS max_population
MATCH (z:Zip)
  WHERE z.pop = max_population
RETURN z;

//19.	Tìm bang có tổng dân số lớn (nhỏ) nhất  CA
MATCH (n:Zip)
WITH n.state AS state, SUM(n.pop) AS total_pop
  ORDER BY total_pop DESC
  LIMIT 1

WITH total_pop
MATCH (m:Zip)
WITH m.state AS state_2, SUM(m.pop) AS total_pop_2, total_pop
  WHERE total_pop_2 = total_pop
RETURN state_2, total_pop_2;
