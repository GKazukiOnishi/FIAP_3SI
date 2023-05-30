import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:foodflow/constants/spacings.dart';

class CustomIcon extends StatelessWidget {
  final String path;
  final Color? color;
  final double dimension;

  const CustomIcon({
    super.key,
    required this.path,
    this.color,
    this.dimension = Spacings.L,
  });

  @override
  Widget build(BuildContext context) {
    return SizedBox.square(
      dimension: dimension,
      child: SvgPicture.asset(
        path,
        height: dimension,
        width: dimension,
      ),
    );
  }
}
