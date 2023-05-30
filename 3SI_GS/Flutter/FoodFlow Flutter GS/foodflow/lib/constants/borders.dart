import 'package:flutter/material.dart';

const double borderWidth = 1.0;

const Radius radius = Radius.zero;
const BorderRadius borderRadius = BorderRadius.all(radius);

InputBorder inputBorder(Color color) {
  return OutlineInputBorder(
    borderSide: BorderSide(
      color: color,
      width: borderWidth,
    ),
    borderRadius: borderRadius,
  );
}

RoundedRectangleBorder shapeBorder(Color color) {
  return RoundedRectangleBorder(
    side: BorderSide(
      color: color,
      width: borderWidth,
    ),
    borderRadius: borderRadius,
  );
}
