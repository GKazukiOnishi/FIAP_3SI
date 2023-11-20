import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { Home } from "./pages/home";
import { Objetivos } from "./pages/objetivos";
import { Indicadores } from "./pages/indicadores";

export const PATH_HOME = "/";
export const PATH_OBJETIVOS = "/objetivos";
export const PATH_INDICADORES = "/indicadores";

const routes = [
  {
    path: PATH_HOME,
    element: <Home />,
  },
  {
    path: PATH_OBJETIVOS,
    element: <Objetivos />,
  },
  {
    path: PATH_INDICADORES,
    element: <Indicadores />,
  },
];

const router = createBrowserRouter(routes);

export const RouterComponent = (props) => {
  return <RouterProvider router={router} />;
};
