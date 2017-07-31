INSERT INTO PARENT_CODE (PARENT_CODE_ID, ATTRIBUTE1, ATTRIBUTE2) values (1, 'Counties', '32 Irish Counties');
INSERT INTO PARENT_CODE (PARENT_CODE_ID, ATTRIBUTE1, ATTRIBUTE2) values (2, 'Pitch Surfaces', 'Pitch Surface Types');
INSERT INTO PARENT_CODE (PARENT_CODE_ID, ATTRIBUTE1, ATTRIBUTE2) values (3, 'Pitch Types', 'Pitch Types');
INSERT INTO CHILD_CODE (CHILD_CODE_ID, ATTRIBUTE1, ATTRIBUTE2, PARENT_CODE_ID) values (1, 'WD', 'Waterford', 1);
INSERT INTO CHILD_CODE (CHILD_CODE_ID, ATTRIBUTE1, ATTRIBUTE2, PARENT_CODE_ID) values (2, 'GRASS', 'Grass Surface', 2);
INSERT INTO CHILD_CODE (CHILD_CODE_ID, ATTRIBUTE1, ATTRIBUTE2, PARENT_CODE_ID) values (3, 'PRIMARY', 'Primary Field', 3);
INSERT INTO CHILD_CODE (CHILD_CODE_ID, ATTRIBUTE1, ATTRIBUTE2, PARENT_CODE_ID) values (4, 'TRAINING', 'Training Field', 3);
INSERT INTO ADDRESS (ADDRESS_ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTALCODE, TOWN, COUNTY_CODE) VALUES (1, 'JFK Park', null, 'Knockanore', null, 'Tallow', 1);
INSERT INTO ADDRESS (ADDRESS_ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTALCODE, TOWN, COUNTY_CODE) VALUES (2, 'Ned Power Field', null, 'Tallow', null, 'Tallow', 1);
INSERT INTO ADDRESS (ADDRESS_ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTALCODE, TOWN, COUNTY_CODE) VALUES (3, 'JFK Temporay Pitch', null, 'Kilwatermoy', null, 'Tallow', 1);
INSERT INTO CLUB (CLUB_ID, NAME, ADDRESS_ID) VALUES (1, 'SHAMROCKS', 1);
INSERT INTO CLUB (CLUB_ID, NAME, ADDRESS_ID) VALUES (2, 'TALLOW', 2);
INSERT INTO PITCH (PITCH_ID, NAME, NUMBER, ADDRESS_ID, SURFACE_CODE, TYPE_CODE) VALUES (1, null, 1, 3, 2, 3);
INSERT INTO OWNER_PITCH_ASSOC (OWNER_PITCH_ASSOC_ID, OWNER_ID, CLUB_ID, PITCH_ID, TYPE) VALUES (1, 1, 1, 1, 'CLUB');
