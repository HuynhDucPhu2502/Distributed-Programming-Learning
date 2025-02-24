// Departments
LOAD CSV WITH HEADERS FROM 'file:///departments.csv' AS row
MERGE (d:Department {id: row.dept_id})
SET d.name = row.name, d.dean = row.dean, d.building = row.building, d.room = row.room;

// Students
LOAD CSV WITH HEADERS FROM 'file:///students.csv' AS row
MERGE (s:Student {id: toInteger(row.student_id)})
SET s.name = row.name, s.gpa = toFloat(row.gpa);

// Courses và liên kết với Department
LOAD CSV WITH HEADERS FROM 'file:///courses.csv' AS row
MERGE (c:Course {id: row.course_id})
SET c.name = row.name, c.hours = toInteger(row.hours)
WITH c, row
MATCH (d:Department {id: row.dept_id})
MERGE (c)-[:BELONGS_TO]->(d);

// liên kết students với courses
LOAD CSV WITH HEADERS FROM 'file:///enrollments.csv' AS row
MATCH (s:Student {id: toInteger(row.student_id)})
MATCH (c:Course {id: row.course_id})
MERGE (s)-[:ENROLLED_IN]->(c);
