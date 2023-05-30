import 'package:flutter/material.dart';
import 'package:foodflow/constants/colorgraphy.dart';

extension ThemeDataExtension on ThemeData {
  bool get isLight => brightness == Brightness.light;
  IColorgraphy get colorgraphy => ThemeColorsFactory().create(brightness);

  Color get kPrimaryColor => colorgraphy.kPrimaryColor;
  Color get kAccentColor => colorgraphy.kAccentColor;
  Color get kBackgroundColor => colorgraphy.kBackgroundColor;
  Color get kDisabledColor => colorgraphy.kDisabledColor;
  Color get kTextPrimaryColor => colorgraphy.kTextPrimaryColor;
  Color get kTextSecondaryColor => colorgraphy.kTextSecondaryColor;
}

extension ColorgraphyExtensions on BuildContext {
  ThemeData get colors => Theme.of(this);
}
