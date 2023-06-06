import 'package:flutter/material.dart';

class AppColors {
  static Color buttonForeground = Colors.white;
  static Color buttonBackground = Color(0xFF0E4F24);
  static Color drawerFontColor = Color(0xFF0E4F24);
  static Color drawerIconColor = const Color(0xFF1C1B1F);
  static Color counterButtonColor = const Color(0xFFCCB6DB);
  static Color? bottomNavigationBarIconColor = Colors.grey[800];

  static ButtonStyle buttonStyle = ElevatedButton.styleFrom(
    elevation: 0,
    foregroundColor: buttonForeground,
    backgroundColor: buttonBackground,
  );

  static ButtonStyle buttonStyleVisualization = ElevatedButton.styleFrom(
      elevation: 0,
      foregroundColor: buttonForeground,
      backgroundColor: buttonBackground,
      padding: const EdgeInsets.all(8));
}
