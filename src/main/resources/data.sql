INSERT INTO tables (NUMBER_TABLE) VALUES (1);
INSERT INTO tables (NUMBER_TABLE) VALUES (2);
INSERT INTO tables (NUMBER_TABLE) VALUES (3);
INSERT INTO tables (NUMBER_TABLE) VALUES (4);
INSERT INTO tables (NUMBER_TABLE) VALUES (5);
INSERT INTO tables (NUMBER_TABLE) VALUES (6);
INSERT INTO tables (NUMBER_TABLE) VALUES (7);
INSERT INTO tables (NUMBER_TABLE) VALUES (8);
INSERT INTO tables (NUMBER_TABLE) VALUES (9);
INSERT INTO tables (NUMBER_TABLE) VALUES (10);
INSERT INTO tables (NUMBER_TABLE) VALUES (11);

INSERT INTO users(EMAIL, PASSWORD, USERNAME) VALUES ('admin@admin.com', 'admin', 'admin');
INSERT INTO user_roles(USER_ID, ROLES) VALUES (1, 'ROLE_ADMIN');


INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Shakshuka',' Free range eggs poached in a sauce of vine tomatoes
  , onions, garlic and extra virgin olive oil. Served with bread.', 15.0,'BREAKFAST');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Scrambled Eggs', 'Eggs scrambled with Swiss, Cheddar Jack and cream cheese topped with fresh herbs.
   Served with seasoned ranch potatoes and an English muffin.', 10.5,'BREAKFAST');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Croissant', 'This classic Croissant is made with 100 percent butter to create a golden,
  crunchy top and soft, flakey layers inside.', 10.80,'BREAKFAST');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Coconut Porridge', ' A delicious oatmeal porridge made with Soya and coconut cream, with oats,
   golden linseed, quinoa, red & wild rice',6.50 ,'BREAKFAST');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Toast', 'French Toast Sourdough bread dipped in a rich egg batter, served golden brown,
  lightly dusted with powdered sugar and served with whipped butter ',7.00 ,'BREAKFAST');

INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Minute Steak', 'Chargrilled, served
with fries, pea shoots and roasted
garlic butter',8.00,'DINNER');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Macaroni Cheese', 'served with a green leaf, avocado and
mixed seed salad, toasted focaccia', 5.00,'DINNER');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Chicken Caesar Salad', 'with baby gem, streaky bacon, poached
egg, croutons, Grana Padano
and Caesar dressing', 6.00,'DINNER');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Ancient Grain Bowl','Salad of wild rice, buckwheat, toasted
millet, black quinoa, asparagus, charred
broccoli, roasted cherry tomatoes,
red pepper, avocado, spring onion, red
pepper tapenade, seeds
and lemon dressing', 3.00,'DINNER');


INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('HUEVOS RANCHEROS', 'Your choice of eggs served over fried tortilla shells, chorizo sausage, black beans, onions and peppers. Topped with melted cheese, salsa, sour cream, jalapeños and green onions.', 6.50 ,'BRUNCH');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Brunch Pie', 'Layers of eggs, cheese, mushrooms, onions, peppers and red skin potatoes, served with a side. | Add ham, bacon or sausage.', 6.00,'BRUNCH');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('FRUITY WAFFLE', 'Our Belgian waffle topped with blueberries, strawberries and bananas. Topped with powdered sugar.', 6.00,'BRUNCH');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('FRISCO BREAKFAST SANDWICH', 'Grilled deli ham, scrambled eggs, and cheddar cheese on grilled sourdough.', 6.00,'BRUNCH');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('SPICY HONEY CHICKEN BISCUIT', 'Fried chicken tender with spicy honey on a biscuit.', 6.00,'BRUNCH');


INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Spicy lamb & feta skewers with Greek brown rice salad', 'Kofta-style kebabs with feta, harissa and onion, served with a wholesome basmati rice flavoured with parsley and mint', 7.50 ,'SUPPER');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Japanese tofu noodle bowl', 'This healthy soup is full of fresh spring flavours and makes a sophisticated vegetarian meal for guests', 3.0,'SUPPER');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Chargrilled vegetable salad', 'Serve these chargrilled vegetables with torn buffalo mozzarella, for a lovely starter or light supper', 5.0,'SUPPER');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Tangy trout', 'Try this healthy trout recipe for a light summer supper', 6.09,'SUPPER');
INSERT INTO meals(NAME, DESCRIPTION, PRICE, TYPE) VALUES ('Chicken gumbo', 'A low-fat Creole-inspired okra and green pepper stew with cayenne, paprika, cumin and thyme', 6.09,'SUPPER');
