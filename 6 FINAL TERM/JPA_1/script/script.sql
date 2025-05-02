INSERT INTO categories (category_id, name, description) VALUES
('cat1', 'Math', 'All about numbers'),
('cat2', 'Science', 'Physics and chemistry'),
('cat3', 'History', 'Past events and people'),
('cat4', 'Literature', 'Books and poetry'),
('cat5', 'Geography', 'Continents and oceans'),
('cat6', 'Biology', 'Living organisms'),
('cat7', 'Computer', 'Tech and programming'),
('cat8', 'Music', 'Instruments and theory'),
('cat9', 'Art', 'Visual expression'),
('cat10', 'Economics', 'Markets and money');

INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES
('q1', 'Algebra', 10, 'cat1'),
('q2', 'Geometry', 8, 'cat1'),
('q3', 'Trigonometry', 9, 'cat1'),
('q4', 'Calculus', 7, 'cat1'),
('q5', 'Statistics', 6, 'cat1'),

('q6', 'Atoms', 9, 'cat2'),
('q7', 'Forces', 8, 'cat2'),
('q8', 'Thermo', 7, 'cat2'),
('q9', 'Electrons', 10, 'cat2'),
('q10', 'Energy', 6, 'cat2'),

('q11', 'WWII', 8, 'cat3'),
('q12', 'Cold War', 7, 'cat3'),
('q13', 'Ancient Rome', 9, 'cat3'),
('q14', 'Vietnam War', 10, 'cat3'),
('q15', 'Industrial Rev.', 6, 'cat3'),

('q16', 'Shakespeare', 9, 'cat4'),
('q17', 'Modern Novels', 8, 'cat4'),
('q18', 'Poetry Forms', 7, 'cat4'),
('q19', 'Drama Basics', 6, 'cat4'),
('q20', 'Classic Lit', 10, 'cat4'),

('q21', 'World Map', 8, 'cat5'),
('q22', 'Capitals', 9, 'cat5'),
('q23', 'Rivers', 7, 'cat5'),
('q24', 'Mountains', 6, 'cat5'),
('q25', 'Climate Zones', 10, 'cat5'),

('q26', 'Cells', 8, 'cat6'),
('q27', 'Genetics', 9, 'cat6'),
('q28', 'Evolution', 7, 'cat6'),
('q29', 'Ecology', 6, 'cat6'),
('q30', 'Anatomy', 10, 'cat6'),

('q31', 'Java', 9, 'cat7'),
('q32', 'Databases', 8, 'cat7'),
('q33', 'Algorithms', 10, 'cat7'),
('q34', 'Networking', 7, 'cat7'),
('q35', 'Cybersecurity', 6, 'cat7'),

('q36', 'Scales', 9, 'cat8'),
('q37', 'Chords', 8, 'cat8'),
('q38', 'Instruments', 7, 'cat8'),
('q39', 'Music Theory', 10, 'cat8'),
('q40', 'Rhythm', 6, 'cat8'),

('q41', 'Painting', 8, 'cat9'),
('q42', 'Sculpture', 9, 'cat9'),
('q43', 'Photography', 7, 'cat9'),
('q44', 'Digital Art', 10, 'cat9'),
('q45', 'Art History', 6, 'cat9'),

('q46', 'Supply Demand', 9, 'cat10'),
('q47', 'Inflation', 8, 'cat10'),
('q48', 'GDP', 7, 'cat10'),
('q49', 'Trade', 10, 'cat10'),
('q50', 'Taxes', 6, 'cat10');



