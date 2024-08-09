local sqlite3 = require("lsqlite3")

-- Open a database connection
local db = sqlite3.open("test.db")

-- Function to perform a vulnerable query
function unsafe_query(username)
    -- Constructing the SQL query with direct string concatenation (vulnerable to SQL injection)
    local sql = "SELECT * FROM users WHERE username = '" .. username .. "';"
    
    for row in db:nrows(sql) do
        print("ID: " .. row.id .. ", Username: " .. row.username .. ", Password: " .. row.password)
    end
end

-- Example usage
local username = arg[1] -- Get the username from the command line arguments
unsafe_query(username)

-- Example usage from the command line: lua sql_injection_example.lua "' OR '1'='1"