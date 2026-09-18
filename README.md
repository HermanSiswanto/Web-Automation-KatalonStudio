# QA Automation Challenge

This project demonstrates end-to-end QA automation skills, including Web UI Automation and Test Design

---

## 📋 Project Overview

The project consists of 2 main parts:

- Test Scenario Design (Gherkin)
- Web Automation using Katalon Studio

The web automation is implemented using the public demo application:

- Web UI: https://www.saucedemo.com

---

## 🎯 Objective

The objective of this project is to demonstrate:

- Test case design using Gherkin
- Maintainable automation framework
- QA analytical thinking

---

## 🛠 Tech Stack

| Tool | Purpose |
|------|---------|
| Katalon Studio | Web UI Automation |
| GitHub | Source Code Repository |

---

## 📂 Project Structure

```
QA-Automation-Challenge
│
├── Object Repository/ # Test Object & Dynamic XPath 
│
├── include/
│   ├── features/ # File Gherkin .feature
│   ├── scripts/groovy/hooks/       # Test execution lifecycle (Open and close browser)
│	└── scripts/groovy/steps/       # Cucumber Step Definitions
│
├── Keywords/                       # Page Object Model (POM) implementation
│	└── pages/                      # Class Page Objects (InventoryPage, etc)
│
├── Test Cases/                     # Test Cases Runner (Smoke, Regression, E2E)
│
├── Test Suites/                    # Test Suite
│
├── docs/
│   ├── 01-Test-Strategy.md
│   ├── 02-Test-Scenarios.md
│   ├── 03-Assumptions.md
│   └── 04-Questions-for-PO-BA.md
│
├── QA-Automation-Project.prj       # Main Project Katalon
│
└── README.md
```

---

## Locator Strategy

The automation framework follows the locator priority below:

1. data-test attribute
2. id attribute
3. name attribute
4. CSS Selector
5. XPath (only when necessary)

Absolute XPath is avoided to improve maintainability.

---

## ✅ Scope

### Web UI Automation

- Login
- Product Listing
- Add to Cart
- Checkout

## 📌 Deliverables

- Katalon Project
- Test Scenarios (Gherkin)
- Assumptions
- Questions for PO/BA

---

## ▶️ How to Run

### Katalon

1. Open Katalon Studio.
2. Import the project.
3. Execute the desired Test Suite or Test Case.

## 📊 Test Execution Report

The comprehensive test execution reports, including interactive HTML dashboards and screenshots, are available for download:
📦 [Download Katalon Test Report (ZIP)](https://github.com/HermanSiswanto/Web-Automation-KatalonStudio/releases/download/v1.0.0/Reports.zip)

## 👤 Author

**Herman Siswanto**

QA Engineer
