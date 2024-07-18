# Vulnerable project

This project contains vulnerable libraries in POM and Gradle files.
It's used to test how snyk exceptions work.

# Folders description
| path                     | description                                                                         |
|--------------------------|-------------------------------------------------------------------------------------|
| cbom                     | Code & dependencies for testing CBOM generation                                     |
| dot-net                  | Dot net dependencies                                                                |
| non-root                 | just testing how well it handles and reports components from other then root folder |
| python                   | just differen types of python dependencies                                          |
| python-internal-packages | python packages that are pointing to internal repos, which cannot be resolved       |
| secrets                  | folders with secret tokens and private keys                                         |
| windows-py               | Python-windows-only dependency                                                      |