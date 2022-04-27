create table `tag`
(
    `id`        char(36) not null,
    `tag_name`  varchar(100) default null,
    `user_id`   char(36)     default null,
    `parent_id` char(36)     default null,
    `create_at` timestamp    default now(),
    primary key (`id`),
    index `tagName` (`tag_name`),
    index `userId` (`user_id`)
);

lock tables `tag` write;
truncate table `tag`;
insert into `tag`
values ('3d4FF1c4-Ac3D-d755-b386-e2CaA52eE43A', '要青电土验小', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF', null, now()),
       ('ec32DEa4-Cb9c-eBCf-Cf9c-EB6d8e3EE6AB', '体商交', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF', null, now()),
       ('7Ad19ddB-dcAA-fc24-B83f-ee6Be6ebb5B3', '专外义然全也二', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF', null, now()),
       ('3C7Cd8cA-CEd1-E8E3-FdFA-C4db56F4c31A', '变两真各相', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF', null, now()),
       ('e4ecBBce-F0B0-Bab3-e18b-d5ddD2DFf03b', '义厂南质院她', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF', null, now()),
       ('b6Ea96ec-87Ad-ABE8-DeE8-8ACeAc7CFA35', '厂从小用', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        '3d4FF1c4-Ac3D-d755-b386-e2CaA52eE43A', now()),
       ('B0fF1b64-EBCc-f4e9-9962-CebEaB437dA6', '济难况市间原', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        '3d4FF1c4-Ac3D-d755-b386-e2CaA52eE43A', now()),
       ('bc35d2DD-7FC1-3F1e-2Da1-CeaeF238dD2e', '想选上', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        '3d4FF1c4-Ac3D-d755-b386-e2CaA52eE43A', now()),
       ('8D9BFeBf-DcbD-dd71-5B59-6dCcE117cB3B', '已北后', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        '3d4FF1c4-Ac3D-d755-b386-e2CaA52eE43A', now()),
       ('e65B193A-DE71-9A4a-8eC9-f8dc8caD6DAa', '条系段布海', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'b6Ea96ec-87Ad-ABE8-DeE8-8ACeAc7CFA35', now()),
       ('dDE83fcA-D63B-66f8-0A4c-6dE8bdCfe0BD', '连受能认务', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'b6Ea96ec-87Ad-ABE8-DeE8-8ACeAc7CFA35', now()),
       ('B911FAC8-5ddc-94CD-61e6-dFaDBAFCCe67', '形素斯物小越', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'e65B193A-DE71-9A4a-8eC9-f8dc8caD6DAa', now()),
       ('C21283cc-F914-DBCc-bd67-72e41E6AE67d', '想江确', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'e65B193A-DE71-9A4a-8eC9-f8dc8caD6DAa', now()),
       ('65EB42c3-CF46-8ED3-D11E-8B4b7f67BBAe', '火天求建', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'e65B193A-DE71-9A4a-8eC9-f8dc8caD6DAa', now()),
       ('efB2DdC7-32c6-c62C-b53d-3be655Db8aFF', '才而分红声', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'ec32DEa4-Cb9c-eBCf-Cf9c-EB6d8e3EE6AB', now()),
       ('6AD287ea-C8c2-992d-b8E5-4e12f5f8fC88', '记米务取角土', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        '7Ad19ddB-dcAA-fc24-B83f-ee6Be6ebb5B3', now()),
       ('c7327De4-D6db-A65B-AeD6-cA6C17fe2AAd', '小风记们成', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        '3C7Cd8cA-CEd1-E8E3-FdFA-C4db56F4c31A', now()),
       ('B76fE3E5-DF6D-Bce1-CE9d-54eFCa3fFbcD', '石电见压亲南小', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'e4ecBBce-F0B0-Bab3-e18b-d5ddD2DFf03b', now()),
       ('68E13da4-B276-B31c-Bafd-63F842F25b7a', '象规分识知', 'ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF',
        'b6Ea96ec-87Ad-ABE8-DeE8-8ACeAc7CFA35', now());
unlock tables;