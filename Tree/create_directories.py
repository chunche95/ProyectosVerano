import os

# Dictionary mapping frameworks to their respective languages
framework_map = {
    'Laravel': 'php',
    'Symfony': 'php',
    'Django': 'python',
    'Flask': 'python',
    'Express': 'nodejs',
    'Spring': 'java',
    'Hibernate': 'java',
    'Angular': 'javascript',
    'React': 'javascript',
    'Vue': 'javascript',
    'Ruby on Rails': 'ruby',
    'Phoenix': 'elixir',
    'Asp.Net': 'csharp',
    'Symfony': 'php',
    'Zend': 'php',
    'Rails': 'ruby',
    # Add more frameworks and languages as needed
}

# Function to create directory structure
def create_directories(course_file):
    with open(course_file, 'r') as file:
        for line in file:
            course = line.strip()
            language = framework_map.get(course, course.lower())
            if not os.path.exists(language):
                os.makedirs(language)
            course_path = os.path.join(language, course.lower())
            if not os.path.exists(course_path):
                os.makedirs(course_path)

if __name__ == '__main__':
    create_directories('cursos.txt')