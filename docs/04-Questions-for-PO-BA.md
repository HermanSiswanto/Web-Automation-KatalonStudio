# Questions for PO / BA

## Q-001 Empty Shopping Cart

What is the expected behavior when the shopping cart is empty?

Should the user:

- be prevented from proceeding to checkout?
- see the Checkout button disabled?
- receive an error message?
- or be allowed to complete an order with a total of $0?


## Q-002 Postal Code

Should the Postal Code field accept:

- numeric values only,
- alphanumeric values,
- or any text input?

## Q-003 Shopping Cart State After User Switch

Observed behavior:
- User A logs in.
- User A adds a product to the shopping cart.
- User A logs out without selecting "Reset App State".
- User B logs in using the same browser.
- User B can still see the product previously added by User A.

Question:
Is this the intended behavior, or should the shopping cart be isolated for each authenticated user?