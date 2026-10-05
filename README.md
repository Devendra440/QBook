# 🎬 QBook – Quick Book

### Java-Based Movie Ticket Booking System

QBook (Quick Book) is a **console-based Movie Ticket Booking System developed using Java**. It allows users to register and log in, browse movies, select shows, choose seats, make payments, view booking confirmations, and cancel bookings.

The project is designed using **Object-Oriented Programming (OOP)** concepts and Java Collections to provide a simple and organized movie booking experience.

---

## 🚀 Features

- 👤 **User Registration**
  - Username validation
  - Mobile number validation
  - Strong password validation
  - Password confirmation

- 🔐 **User Login**
  - Username and password authentication
  - Access to movie booking after successful login

- 🎬 **Movie Listing**
  - View available movies
  - Movie name, language, genre, duration, rating, and description
  - Select a movie to view detailed information

- 📅 **Show Selection**
  - Select movie show date
  - Select theatre
  - Select screen
  - Select show time
  - Movie-specific ticket pricing

- 💺 **Seat Selection**
  - View available and booked seats
  - Select multiple seats
  - Remove selected seats
  - Seat availability is maintained for different movie shows

- 💳 **Payment**
  - UPI payment
  - Credit/Debit Card payment
  - Automatic ticket price calculation
  - Payment status handling

- 🎟️ **Booking Confirmation**
  - Generate booking details
  - Display movie, theatre, screen, date, time, seats, tickets, amount, and payment method
  - View ticket details

- ❌ **Booking Cancellation**
  - Cancel confirmed bookings
  - Selected seats become available again
  - Refund amount is displayed

---

## 🛠️ Technologies Used

| Technology | Usage |
|---|---|
| **Java** | Core application development |
| **OOP** | Classes, Objects, Inheritance, Abstraction |
| **Java Collections** | Managing users and seat information |
| **ArrayList** | User data management |
| **HashMap** | Seat availability management |
| **Java Scanner** | Console input |
| **Git & GitHub** | Version control and project hosting |

---

## 🧠 Java Concepts Used

This project demonstrates important Java programming concepts:

- Classes and Objects
- Constructors
- Encapsulation
- Inheritance
- Abstraction
- Method Overriding
- Abstract Classes
- Static Members
- ArrayList
- HashMap
- Conditional Statements
- Loops
- Exception Handling
- String Manipulation
- Input Validation

---

## 📂 Project Structure

```text
QBook/
│
├── Menu.java
├── MainMenu.java
│
├── User.java
├── UserRegistration.java
├── UserLogin.java
│
├── Movie.java
├── MovieList.java
├── MovieDetails.java
│
├── ShowSelection.java
├── SeatSelection.java
│
├── Payment.java
├── UPIPayment.java
├── CreditCardPayment.java
│
├── BookingConfirmation.java
├── BookingCancellation.java
│
└── README.md
```

---

## 🔄 Application Flow

```text
Start Application
       ↓
Main Menu
       ↓
Register / Login
       ↓
Movie List
       ↓
Movie Details
       ↓
Select Show
       ↓
Select Theatre
       ↓
Select Screen
       ↓
Select Date & Time
       ↓
Select Seats
       ↓
Choose Payment Method
       ↓
Make Payment
       ↓
Booking Confirmation
       ↓
View Ticket / Cancel Booking
```

---

## 🎬 Sample Movies

The current project includes movies such as:

- **Pushpa 2**
- **Kalki 2898 AD**
- **Devara**

Each movie contains information such as:

- Movie ID
- Movie Name
- Language
- Genre
- Duration
- Rating
- Description

---

## 🏢 Theatre & Show Management

Users can select from available theatres and show details.

### Theatres

- PVR Cinemas
- INOX
- CMR Cinemas

### Show Times

- 10:00 AM
- 2:00 PM
- 6:00 PM
- 10:00 PM

### Screens

- Screen 1
- Screen 2

The application also supports multiple show dates and calculates ticket prices according to the selected movie and theatre.

---

## 💺 Seat Management

QBook uses seat status management to control seat availability.

```text
0 → Available
1 → Booked
2 → Selected
```

Seats are organized using rows such as:

```text
A
B
C
D
E
F
```

Users can select seats before proceeding to payment.

After successful payment:

```text
Selected → Booked
```

If payment fails:

```text
Selected → Available
```

If a booking is cancelled:

```text
Booked → Available
```

---

## 💳 Payment Methods

QBook currently supports:

### UPI Payment

Users can complete payment using a UPI-based payment flow.

### Credit/Debit Card Payment

Users can enter card-related payment details through the console interface.

The system calculates the total booking amount based on:

```text
Total Amount = Number of Tickets × Ticket Price
```

---

## 🎟️ Booking Confirmation

After successful payment, QBook displays booking information including:

```text
Booking ID
Movie
Theatre
Screen
Date
Show Time
Selected Seats
Number of Tickets
Total Amount
Payment Method
Booking Status
```

---

## ❌ Booking Cancellation

Users can cancel a confirmed booking.

The system:

1. Displays booking details.
2. Asks for cancellation confirmation.
3. Releases the booked seats.
4. Displays the refund amount.
5. Updates the booking status.

---

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Devendra440/QBook.git
```

### 2. Open the Project

Open the project in any Java-supported IDE such as:

- IntelliJ IDEA
- Eclipse
- VS Code
- Spring Tool Suite

### 3. Compile the Java Files

Make sure Java is installed on your system.

```bash
javac *.java
```

### 4. Run the Application

```bash
java Menu
```

---

## 📋 Requirements

Before running the project, make sure you have:

- Java JDK 8 or higher
- Java-supported IDE
- Git
- Basic command-line environment

---

## 🔮 Future Enhancements

The project can be extended with:

- 🗄️ MySQL database integration
- 🌐 Web-based interface
- 🔑 Role-based authentication
- 👨‍💼 Admin dashboard
- 🎫 E-ticket generation
- 📧 Email booking confirmation
- 📱 SMS notification
- 💰 Multiple payment gateways
- ⭐ Movie reviews and ratings
- 🔍 Movie search and filtering
- 📊 Booking history
- ☁️ Cloud deployment
- 🔐 Secure password encryption

---

## 🎯 Learning Outcomes

Through this project, I practiced:

- Building a complete Java console application
- Applying OOP principles
- Working with Java Collections
- Implementing user input validation
- Managing application flow
- Designing seat booking logic
- Implementing payment processing flow
- Handling booking cancellation
- Organizing Java classes into functional modules
- Using Git and GitHub for project management

---

## 👨‍💻 Developer

**Devendra Gupta**

🎓 B.Tech – Computer Science & Engineering  
🏫 Malla Reddy University, Hyderabad

### Skills Demonstrated

`Java` `OOP` `Collections` `SQL` `Git` `GitHub` `Problem Solving`

---

## ⭐ Project Highlights

> **QBook – Quick Book** demonstrates a complete movie ticket booking workflow using Core Java and Object-Oriented Programming concepts.

**User → Movie → Show → Seat → Payment → Booking → Cancellation**

---

## 📄 License

This project is available under the **MIT License**.

---

⭐ If you find this project useful, consider giving the repository a star!
