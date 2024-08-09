equire 'mysql2'

# Database configuration
client = Mysql2::Client.new(
    :host => "localhost",
    :username => "root",
    :password => "password",
    :database => "testdb"
)

def unsafe_query(client, username)
# Constructing the SQL query with direct string concatenation (vulnerable to SQL injection)
    query = "SELECT * FROM users WHERE username = '#{username}';"
    results = client.query(query)
    results.each do |row|
    puts row
    end
end

# Example usage
username = ARGV[0]
unsafe_query(client, username)

# Example usage from the command line: ruby sql_injection_example.rb "' OR '1'='1"