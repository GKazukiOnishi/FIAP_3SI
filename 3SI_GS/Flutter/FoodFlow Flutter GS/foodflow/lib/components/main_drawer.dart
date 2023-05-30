import 'package:flutter/material.dart';
import 'package:foodflow/screens/historic_page.dart';
import 'package:foodflow/themes/app_colors.dart';

import '../screens/home.dart';

class MainDrawer extends StatelessWidget {
  const MainDrawer({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Drawer(
        backgroundColor: Theme.of(context).colorScheme.surfaceVariant,
        child: ListView(
          children: <Widget>[
            ListTile(
                title: Text(
              "FoodFlow",
              style: TextStyle(
                  fontSize: 20,
                  color: AppColors.drawerFontColor,
                  fontWeight: FontWeight.w500),
            )),
            ListTile(
              textColor: AppColors.drawerFontColor,
              title: const Text(
                "Culturas",
                style: TextStyle(fontWeight: FontWeight.w700),
              ),
            ),
            ListTile(
              iconColor: AppColors.drawerIconColor,
              onTap: () {
                Navigator.push(context, MaterialPageRoute(builder: ((context) {
                  return const Home();
                })));
              },
              title: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: const <Widget>[
                    Icon(Icons.eco),
                    Expanded(
                        child: Padding(
                      padding: EdgeInsets.symmetric(horizontal: 8.0),
                      child: Text(
                        "Café",
                        style: TextStyle(fontWeight: FontWeight.w700),
                      ),
                    )),
                    Text(
                      "Novas Fotos 100+",
                      style: TextStyle(fontWeight: FontWeight.w700),
                    )
                  ]),
            ),
            ListTile(
              iconColor: AppColors.drawerIconColor,
              textColor: AppColors.drawerFontColor,
              onTap: () {},
              title: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: const <Widget>[
                    Icon(Icons.forest),
                    Expanded(
                        child: Padding(
                      padding: EdgeInsets.symmetric(horizontal: 8.0),
                      child: Text(
                        "Milho",
                        style: TextStyle(fontWeight: FontWeight.w700),
                      ),
                    )),
                    Text(
                      "Novas Fotos 30+",
                      style: TextStyle(fontWeight: FontWeight.w700),
                    )
                  ]),
            )
          ],
        ));
  }
}
