# Test Strategy

## 1. Objective

The objective of this project is to validate the core functionality of the demo E-Commerce application (SauceDemo) and REST API (ReqRes) through automated testing.

This project aims to demonstrate:

- Test scenario design using Gherkin.
- Web UI automation using Katalon Studio.
- API testing using Postman.
- Basic performance testing using Apache JMeter.
- QA analytical thinking through assumptions, ambiguity identification, and bug reporting.

---

# 2. Scope

## In Scope

### Web UI (SauceDemo)

- User Login
- Product Listing
- Add Product to Cart
- Shopping Cart
- Checkout Information
- Checkout Overview
- Order Completion

## Out of Scope

The following items are outside the scope of this challenge:

- Cross-browser testing
- Responsive/mobile testing
- Accessibility testing
- Security testing
- Database validation
- Email verification
- Visual/UI comparison testing

---

# 3. Test Approach

Testing is divided into three categories.

## Functional Testing

Validate that each feature behaves according to the expected business flow.

Coverage includes:

- Positive scenarios
- Negative scenarios
- Edge cases

---

## Automation Testing

Automation is implemented using Katalon Studio.

Best practices applied include:

- Organized Object Repository by page
- Explicit waits instead of hard-coded delays
- Reusable test objects
- Reusable keywords
- Looping for repetitive actions
- Conditional logic where applicable

---

# 4. Test Design Technique

The following test design techniques are used throughout this project.

- Positive Testing
- Negative Testing
- Edge Case Testing

---

# 5. Test Environment

## Web Application

https://www.saucedemo.com


---

# 6. Test Data

## Valid User

standard_user

secret_sauce

---

## Locked User

locked_out_user

secret_sauce

---

## Invalid User

invalid_user

invalid_password

---

# 7. Entry Criteria

Testing can begin when:

- Application is accessible.
- Test environment is available.
- Required test accounts are ready.

---

# 8. Exit Criteria

Testing is considered complete when:

- All planned scenarios have been executed.
- Automation scripts run successfully.

---

# 9. Risks

Potential risks identified during testing include:

- Public demo environment may experience downtime.
- Test data may change without notice.
- Network latency may affect execution time.
- Dynamic elements may introduce flaky automation if synchronization is not handled properly.

---

# 10. Deliverables

This submission includes:

- Gherkin Test Scenarios
- Katalon Automation Project
- Test Strategy
- Test Scenarios
- Assumptions
- Questions for PO/BA

---

# 11. Assumptions

The following assumptions are made due to limited project requirements:

- Public demo applications are considered stable during execution.
- Existing demo accounts remain available.
- Successful checkout is indicated by the order confirmation page.
- No backend/database validation is required.
- API responses follow the published ReqRes contract unless stated otherwise.