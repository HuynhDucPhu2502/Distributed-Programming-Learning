// import data
LOAD CSV WITH HEADERS FROM 'file:///students.csv' AS row
CREATE (:Student {student_id: row.student_id, name: row.name, gpa: toInteger(row.gpa)});

LOAD CSV WITH HEADERS FROM 'file:///departments.csv' AS row
CREATE (:Department {dept_id: row.dept_id, name: row.name, dean: row.dean, building: row.building, room: row.room});

LOAD CSV WITH HEADERS FROM 'file:///courses.csv' AS row
CREATE (:Course {course_id: row.course_id, name: row.name, hours: toInteger(row.hours), dept_id: row.dept_id});

MATCH (c:Course), (d:Department)
  WHERE c.dept_id = d.dept_id
CREATE (c)-[:BELONGS_TO]->(d);

LOAD CSV WITH HEADERS FROM 'file:///enrollments.csv' AS row
MATCH (s:Student {student_id: row.student_id}), (c:Course {course_id: row.course_id})
CREATE (s)-[:ENROLLED_IN]->(c);