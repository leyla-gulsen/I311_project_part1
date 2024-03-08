# Java GUIs Program Project Part 1

**Course**: INFO-I 311, Application Development, Fall 2023 <br>
**Institution**: Indiana University <br>
**Final Product**: Screenshots of the complete Java program can be seen in the README.md of the repository for part 2 of the project [here](https://github.com/leyla-gulsen/I311_project_part2).
> Imported from my IU enterprise account github.iu.edu/lsgulsen

## Project Overview

This program is a comprehensive solution designed for Thneed Inc. to efficiently manage its customer base and orders through an interactive graphical user interface (GUI). The application facilitates meticulous tracking of customer details along with their current and past orders, ensuring a seamless operational flow from order placement to fulfillment.
> For more information, course assignment requirements, and detailed documentation, please visit the [project Wiki](https://github.com/leyla-gulsen/I311_project_part1/wiki).

### Learning Objectives
- Understand the fundamentals of the Java language
- Write your own fully functional GUI applications in Java, using Eclipse
- Be familiar with the GIT environment and understand version control
- Understand task allocation and time management in a small team environment
- Implement JUnit testing throughout the program

## Technologies and Tools Used

- Java
- JUnit
- SceneBuilder
- Eclipse
- Git

## Features and Functionality

### Customer Management
- **Customer Objects**: Each customer object captures essential information, including a unique Customer ID, name, address, phone number, and a comprehensive list of associated orders (both current and past), ensuring a detailed record is maintained for every client.
- **View Customer Details**: Through the GUI, users can view detailed information about customers, especially when a specific order is selected, enhancing the understanding of customer-order relationships.
### Order Handling
- **Order Objects**: Order objects meticulously detail each transaction, specifying the customer involved, the quantity and specifics of Thneeds ordered (including size and color variations), and crucial timestamps marking the order and fulfillment dates.
- **Dynamic Order Display**: The GUI prioritizes the display of unfilled orders by their age, followed by filled orders, organized by recent fulfillment, ensuring critical orders are addressed promptly.
- **Order Selection and Modification**: Users can select individual orders to view or update details, specifically the fulfillment date, within the same interface to avoid disruption in order management workflow.
### Graphical User Interface (GUI)
- **Integrated View and Interaction**: The GUI is segmented into three primary areas, allowing users to display all orders, interact with detailed views of selected orders without navigating away, and access or input customer data relevant to orders.
- **Data Interaction**: Beyond viewing, the interface facilitates the addition of new orders with the capability to associate existing customers or add new ones, and the adjustment of order fulfillment dates with immediate effect upon confirmation.
- **Persistence Controls**: A dedicated mechanism within the GUI ensures all changes to customer and order data can be explicitly saved at any point, or automatically upon application closure, to a predefined flat file, preserving the state of business data.
### Data Persistence and Initialization
- **File I/O Operations**: The application is equipped to automatically search for, and load, existing business data from a flat file at startup. In the absence of such a file, it initializes with a clean slate. Equally, it supports the saving of all operational data to this file, ensuring continuity and data integrity across sessions.
### Collaborative Development Approach
- The development process is strategically divided among roles focusing on the Customer and Order classes, GUI development, and File I/O functionalities, with additional leadership in architectural planning, testing, and documentation/repository management to promote a cohesive and robust software solution.

## Challenges and Learnings

The biggest challenge for me was implementing the File I/O class. This was my first project using Git within a group, and it was difficult knowing when and where to enable the File I/O class along with the other classes of Order and Customer, all without interrupting each class' independent functionality.

## Final Outcome

The project met all of the course requirements and is a fully functional Java GUI progam. It was a valuable learning experience working with a team within a Git interface. It was also exciting learning Java while also seeing the program come to life within the GUI created in SceneBuilder.

## Acknowledgments
Professor J Duncan for teaching the course and creating a project that was a great learning experience, and Teaching Assistants Andy Myers, Erika Becker, and Jeff Hochgesgang for guidance and insights.
