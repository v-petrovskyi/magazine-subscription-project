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

insert into magazines(active, price, title, image_path, description) values (TRUE, 220.52, 'HOLA', 'https://cdn-assets.ziniopro.com/var/site_199/storage/images/media2/cover2108/1642347-1-eng-GB/cover2.jpg', 'La edición digital de Hola magazine es una reproducción exacta de la edición impresa con todos los beneficios de interactividad que aporta la navegación electrónica. Hola magazines le ofrece cada semana a sus lectores exclusivas y reportajes de lujo, fotos de de gran calidad, noticias de actualidad, toda la revista Hola al completo página a página en su ordenador. También disponible Hola Magazine México y Hola Magazine España!');
insert into magazines(active, price, title, image_path, description) values (TRUE, 211.05, 'Techlife News', 'https://cdn-assets.ziniopro.com/var/site_392/storage/images/media2/cover445/814136-1-eng-GB/cover2.jpg', 'Read the most relevant news of the week about the world of technology and its influence on our lives. New products, Apps, acquisitions in the industry, highlights about the digital world and everything about your favorite iGadgets and upgrades. Everything you need to keep well informed. A new concept of light, intelligent, innovative reading at your fingertips. A global view of Tech LifeStyle and its influence on our lives.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 4.99, 'Cosmopolitan US', 'https://files.magzter.com/resize/magazine/1357654341/1670493833/view/2.jpg', 'The largest-selling young women''s magazine in the world, Cosmopolitan is famous for its upbeat style, focus on the young career woman and candid discussion of contemporary male/female relationships. Since its founding in 1886, Cosmopolitan has been reporting on modern social trends...');
insert into magazines(active, price, title, image_path, description) values (TRUE, 4.99, 'Men''s Health US', 'https://files.magzter.com/resize/magazine/1522354075/1675265829/view/2.jpg', 'Magazine Description: Men''s Health isn’t just a magazine—it’s a solution. We give you the tools to look better, live healthier, and be more successful in all aspects of life. Subscribe now and find out why Men’s Health is the world’s largest men’s magazine!');
insert into magazines(active, price, title, image_path, description) values (TRUE, 4.99, 'Motor Trend', 'https://files.magzter.com/resize/magazine/1391672550/1674479391/view/2.jpg', 'Motor Trend is the world''s automotive authority. Every issue of Motor Trend informs and entertains with features on the testing of both domestic and import cars, car care, motor sports coverage, sneak peeks at future vehicles, and auto-industry news.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 3.99, 'Maxim US', 'https://files.magzter.com/resize/magazine/1343679896/1671826794/view/2.jpg', 'Maxim, the world''s leading men''s magazine, offers readers a cutting edge and humorous dose of what they want most in life: beautiful women, cars, gadgets, sports, entertainment, and the know-how to get ahead in the world. Quite simply, it''s the modern man''s guide to living the good life.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 5.99, 'TV Guide Magazine', 'https://files.magzter.com/resize/magazine/1429714855/1674223280/view/2.jpg', 'One of the most popular magazines in the country, TV Guide Magazine is the only publication devoted exclusively to television—the shows, the stars and the entertainment industry. With its unparalleled access and authority, TV Guide Magazine covers every aspect of America''s most popular pastime—celebrity interviews, in-depth previews, sneak peeks and exclusive scoop on all your favorites. In every issue, TV Guide Magazine tells you what''s worth watching. The Magzter Edition of TV Guide Magazine contains all the articles found in the print edition, including senior critic Matt Roush''s weekly reviews, as well as nightly prime-time listings (both Eastern and Pacific times).');
insert into magazines(active, price, title, image_path, description) values (TRUE, 5.99, 'Star', 'https://files.magzter.com/resize/magazine/1369067356/1675173580/view/2.jpg', 'Star is all about entertainment, from the best and latest breaking celebrity news, to the movies and music that everyone is talking about.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 4.99, 'National Enquirer', 'https://files.magzter.com/resize/magazine/1369067063/1675173343/view/2.jpg', 'The National Enquirer reports the unvarnished stories about celebrities, their antics, celebrations, loves and mishaps. Also included in the editorial mix are high-profile stories regarding current criminal investigations, human interest and health. No matter what is reported, National Enquirer readers are the first to know!');
insert into magazines(active, price, title, image_path, description) values (TRUE, 5.99, 'Us Weekly', 'https://files.magzter.com/resize/magazine/1494518166/1675240110/view/2.jpg', 'Us Weekly is a pop culture and entertainment magazine that gives readers a unique perspective into the lives of celebrities and an inside look at Hollywood''s biggest stories. Each issue includes photos of favorite stars as well as interesting stores about that they''re like when the cameras are off.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 1.99, 'inTouch', 'https://files.magzter.com/resize/magazine/1626675041/1675172798/view/2.jpg', 'Witty and completely entertaining, In Touch is the magazine for the celebrity obsessed reader. With its’ strong photo-centric layout and irreverent, lighthearted copy, In Touch delivers that week’s Hollywood headlines with a lighter twist. Created for the fan-centric reader, In Touch unabashedly delivers the fun and lavishness of Hollywood life.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 2.99, 'Woman''s World', 'https://files.magzter.com/resize/magazine/1650870188/1675338980/view/2.jpg', 'Woman’s World is a warm voice in a cold world, a comforting hug, a reliable friend. It’s a feel-good read filled with everything the reader needs to make her week better and happier, to feel healthier, to express her creativity and to share her love. Woman’s World makes a meaningful and lasting emotional connection with the reader, a connection that’s evidenced by its place at the top of the newsstand.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 3.99, 'First for Women', 'https://files.magzter.com/resize/magazine/1650870458/1674127944/view/2.jpg', 'First for Women offers women the tools and inspiration they need to look good, feel great and enjoy every aspect of their lives, with guidance and encouragement on topics like beauty, fashion, health, food, home and family. Understanding how busy our readers are, First for Women offers visually driven, reliable information in bite-sized nuggets within a larger, clearly organized framework. Bright, friendly, smart and engaging, First for Women is the go-to for women on the go.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 4.99, 'Entrepreneur US', 'https://files.magzter.com/resize/magazine/1422355276/1673858232/view/2.jpg', 'Entrepreneur magazine is the trusted source for growing your business and offers surefire strategies for success. Whether you are just thinking of starting a business, have taken the first steps, or already own a business, Entrepreneur offers the best advice on running your own company');
insert into magazines(active, price, title, image_path, description) values (TRUE, 6.99, 'PCWorld', 'https://files.magzter.com/resize/magazine/1409095068/1672866879/view/2.jpg', 'PCWorld is the best source of information on how to select, buy, and use computer products and services for home and business. This app lets you read PCWorld magazine every month, right on your iPad. Existing print subscribers can activate their digital subscription, and get access to the PCWorld Digital All-Access Pass, which allows you to access PCWorld in any version, and on any device, including the PCWorld Digital Magazine (U.S.) for all iPads. Use the links below for more information. Additionally, you can buy individual issues or subscribe, all right within the app. PCWorld offers buying advice through opinionated reviews and PCWorld Labs-based evaluations of new products, provides authoritative analysis of technology news and trends, and gives practical tips on everything from troubleshooting Windows to securing wireless networks. PCWorld is also the only magazine in its category that routinely pursues investigative and consumer-advocacy stories. Engaging, jargon-free writing and friendly design make the magazine as enjoyable as it is useful.In every issue of PCWorld you''ll get advice and tips on staying secure in the Security Alert section, and news about the latest software bugs and fixes. The Consumer Watch section provides practical shopping and buying advice. The Here''s How tips provide hands-on, step-by-step guides to upgrading and troubleshooting your gear. There''s one clear choice when it comes to reading about the latest tech products and innovations: PCWorld magazine.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 6.99, 'Kiplinger''s Personal Finance', 'https://files.magzter.com/resize/magazine/1344459782/1672665762/view/2.jpg', 'KIPLINGER''S PERSONAL FINANCE provides down-to-earth advice on managing money and achieving financial security. We provide our readers with trustworthy information and practical guidance on saving, investing, planning for retirement, paying for college, buying an automobile, home and other major purchases, as well as reliable advice for all stages of their financial lives. Our readers are affluent and influential men and women who are actively involved in their personal-finance decisions, and we are guided by the expectation that they will act on what we write about and benefit from doing so.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 5.99, 'Time ', 'https://files.magzter.com/resize/magazine/1452683603/1675336282/view/2.jpg', 'TIME’s signature voice and trusted content make it one of the most recognized news brands in the world. Offering incisive reporting, lively writing and world-renowned photography, TIME has been credited with bringing journalism at its best into the fabric of American life. Every issue delivers a deeper understanding of the world we live in.');
insert into magazines(active, price, title, image_path, description) values (FALSE, 3.99, 'Good House Keeping - US', 'https://files.magzter.com/resize/magazine/1357655060/1673518629/view/2.jpg', 'Good Housekeeping - Home of the Good Housekeeping Seal and your best source for saving time, money, and hassle...');
insert into magazines(active, price, title, image_path, description) values (TRUE, 7.99, 'Kandy Magazine', 'https://files.magzter.com/resize/magazine/1332392287/1673385016/view/2.jpg', 'Get KANDY! Who loves beautiful women? Kandy readers! Who loves being treated like a nightlife VIP? Kandy readers! Who wants to know what women think? Kandy readers! Well, Kandy delivers all that and more … Kandy magazine is the top downloaded men’s interests lifestyle and entertainment magazine worldwide. In more than 150 countries, Kandy features beautiful sexy women, hot girls, MAXIM and Playboy style models and photography. There is no nudity. The magazine is not only filled with entertaining articles but is also a visual masterpiece filled with incredible pictorials. Kandy Magazine, the fastest growing men’s interests magazine around the world, delivers month after month columns that today’s man demand. Get the freshest outlook on modern style and culture. Kandy offers a current perspective on the world around you with in-depth articles about gadgets, tech, nightlife, cars, music, movies, video games, athletes and celebrity interviews, and sports coverage on football, soccer, hockey, baseball, basketball and MMA. Every issue includes interviews and pictorials of the hottest women in the world. Your Kandy experience starts with: The Girlfriend Experience - first impressions matter and with the girlfriend perspective on fashion and style we uncover your own personal attitude that best suits you The Buddy Experience - Firsthand, unbiased ""test drive"" knowledge from ""your boy""; guidance and recommendations on vacation spots, autos, watches, bachelor cooking, fine dining, wines and spirits. Kandy Concierge – As a Kandy subscriber you are immediately a member of an exclusive inner circle. The Concierge brings you a network and knowledge only 1% of the population can access. Kandy Dating – The Kandy girls are here to cure reader mail dating ills and the girls of Kandy will share with you tips on how to go from being the hunter to the hunted! The Geek Experience – Yeah, we all have a little geek inside of us no matter how hard we try to portray a cool exterior. So, for your inner geek, we provide the latest must-have gadgets. And, most important, The Cool Hand Luke Experience - Kandy insiders share with you the secrets to keeping cool under pressure enabling you to exude a stealth confidence that puts you in the driver''s seat no matter the circumstance.');
insert into magazines(active, price, title, image_path, description) values (FALSE, 4.99, 'Women Fitness', 'https://files.magzter.com/resize/magazine/1520854278/1674629841/view/2.jpg', 'Women Fitness Magazine brings to you the best from the world of health, fitness, nutrition, beauty and fashion to inspire and motivate you to be the best version of yourself.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 7.99, 'Condé Nast Traveler US', 'https://files.magzter.com/resize/magazine/1450523306/1671453321/view/2.jpg', 'Condé Nast Traveler creates images and narratives that let you immerse yourself in the wonder of travel. More than ever, we’re committed to inspiring life-changing travel experiences.');
insert into magazines(active, price, title, image_path, description) values (FALSE, 4.99, 'Southern Living', 'https://files.magzter.com/resize/magazine/1453375455/1674135185/view/2.jpg', 'SOUTHERN LIVING celebrates the legendary food, gracious homes, lush gardens, and distinct places that make the South unique. In every edition you’ll find dozens of recipes prepared in our famous test kitchens, guides to the best travel experiences, decorating ideas and inspiration, and gardening tips tailored specifically to your climate.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 4.99, 'Real Simple', 'https://files.magzter.com/resize/magazine/1452681259/1674134945/view/2.jpg', 'Real Simple magazine provides smart, practical, beautiful solutions to make life easier—every single day. Each inspiring issue is packed with fast and delicious recipes, organizing and decorating ideas, great fashion and beauty finds, money-saving tips, and more. Real Simple magazine provides smart, practical, beautiful solutions to make life easier—every single day. Each inspiring issue is packed with fast and delicious recipes, organizing and decorating ideas, great fashion and beauty finds, money-saving tips, and more.');
insert into magazines(active, price, title, image_path, description) values (FALSE, 5.99, 'Sports Illustrated US', 'https://files.magzter.com/resize/magazine/1452683429/1674803776/view/2.jpg', 'Through emotional storytelling and award-winning photography, Sports Illustrated provides you with complete coverage of all your favorite sports, including the NFL, College Football, Baseball, College Basketball, the NBA and more.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 6.99, 'Mancave Playbabes', 'https://files.magzter.com/resize/magazine/1382413171/1672986500/view/2.jpg', 'Mancave Playbabes is more than an escape for men; it’s a sanctuary for all that is good! Discover your inner Mancave today.');
insert into magazines(active, price, title, image_path, description) values (TRUE, 4.99, 'Fast Company', 'https://files.magzter.com/resize/magazine/1363194279/1669707378/view/2.jpg', 'Fast Company is the world’s leading progressive business media brand, with a unique editorial focus on innovation in technology, leadership, world-changing ideas, and design. Written for, by, and about the most progressive business leaders, Fast Company inspires readers to think beyond traditional boundaries, lead conversations, and create the future of business.');
insert into magazines(active, price, title, image_path, description) values (FALSE, 4.99, 'Inc.', 'https://files.magzter.com/resize/magazine/1363631886/1670249838/view/2.jpg', 'Founded in 1979 and acquired in 2005 by Mansueto Ventures LLC, Inc. is the only major brand dedicated exclusively to owners and managers of growing private companies, with the aim to deliver real solutions for today’s innovative company builders.');
