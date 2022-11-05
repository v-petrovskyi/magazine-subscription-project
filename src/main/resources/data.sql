insert into magazines(active, price, title, image_path)
values (true, 40.5, 'Real Simple - Digital', 'https://i.ibb.co/W3y4pp8/image.png');
insert into magazines(active, price, title, image_path)
values (true, 15.5, 'Allrecipes - Digital', 'https://i.ibb.co/ZNfHYcN/image.png');
insert into magazines(active, price, title, image_path)
values (true, 40.5, 'PEOPLE - Digital', 'https://i.ibb.co/NmszRWp/image.png');
insert into magazines(active, price, title, image_path)
values (true, 20.5, 'Better Homes & Gardens - Digital', 'https://i.ibb.co/nCvB4XQ/image.png');
insert into magazines(active, price, title, image_path)
values (true, 21.55, 'People Royals - Digital', 'https://i.ibb.co/pP3yLJH/image.png');

insert into users(user_name, email, password, role)
values ('user', 'user@email.com', '$2a$12$dp72gJ8xcaSaE45T7nnV3em5W3P216ftizBBy/Gx.JWtZAX6FdukW', 'ROLE_USER');
insert into users(user_name, email, password, role)
values ('admin', 'admin@email.com', '$2a$12$3YPysAPL4PeaduKOwORtUe2Kg3NXv.RKY0K78nZs7zDtIG2FULR36', 'ROLE_ADMIN');

update magazines
set description = 'Real Simple is dedicated to making your everyday life easier so you can focus on what you love to do most. Each issue offers smart solutions and inspiring ideas for delicious weeknight meals, home organization and decor, beauty and style, health and wellness, personal finance, work-life balance, and so much more. A Real Simple subscription will give you the tools to live a more beautiful, mindful, and meaningful life.

Real Simple, published by Meredith, currently publishes two double issues, which counts as two of 12 issues in an annual subscription. Frequency of all magazines subject to change without notice. Additional double issues may be published, which count as 2 issues. Applicable sales tax will be added.'
where title = 'Real Simple - Digital';

update magazines
set description = 'Allrecipes combines the best recipes from their extensive network of home cooks with the latest tips & tools to help you thrive in the kitchen year-round. Inside each issue you''ll find quick & easy weeknight meals; simple side dishes to pair with seasonal favorites; and even what to make with your kids! Anyone who loves to cook will feel right at home with Allrecipes.

Allrecipes Magazine, published by Meredith, currently publishes 6 times annually. Frequency of all magazines subject to change without notice. Additional double issues may be published, which count as 2 issues. Applicable sales tax will be added.'
where title = 'Allrecipes - Digital';

update magazines
set description = 'PEOPLE is the No. 1 source for celebrity news, true crime sagas, royal family updates, and inspirational stories of ordinary people doing extraordinary things. Subscribe to PEOPLE today to stay in the know and gain instant access to the world''s biggest stories.

PEOPLE, published by Meredith, currently publishes 4 double issues. Each count as two of 56 issues in an annual subscription. Frequency of all magazines subject to change without notice. Additional double issues may be published, which count as 2 issues. Applicable sales tax will be added.'
where title = 'PEOPLE - Digital';

update magazines
set description = 'Better Homes & Gardens is the essential magazine for homeowners and gardeners, everyday organizers, home cooks and DIY decorators. For classic design, on-trend styles, fresh recipes, and the latest beauty & wellness tips, a subscription to Better Homes & Gardens makes certain you''ll always be in season.

Better Homes & Gardens, published by Meredith, currently publishes two double issues, which counts as two of 12 issues in an annual subscription. Frequency of all magazines subject to change without notice. Additional double issues may be published, which count as 2 issues. Applicable sales tax will be added.'
where title = 'Better Homes & Gardens - Digital';

update magazines
set description = 'PEOPLE Royals is the No.1 magazine for exclusive access to the British royal family. Celebrate every ceremony, holiday and family milestone, along with in-depth interviews, gorgeous photography, and more! If you''re a royal enthusiast, this is your chance to slip behind the palace gates and access content you won''t find anywhere else.

PEOPLE Royals, published by Meredith, currently publishes 4 times annually. Frequency of all magazines subject to change without notice. Additional double issues may be published, which count as 2 issues. Applicable sales tax will be added.'
where title = 'People Royals - Digital';

