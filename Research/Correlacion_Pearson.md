### ¿Qué es la correlación pearson?

El coeficiente de correlación de Pearson, pensado para variables cuantitativas (escala mínima de intervalo), es un índice que mide el grado de covariación entre distintas variables relacionadas linealmente. Adviértase que decimos "variables relacionadas linealmente''.Esto significa que puede haber variables fuertemente relacionadas, pero no de forma lineal, en cuyo caso no proceder a aplicarse la correlación de Pearson. Por ejemplo, la relación entre la ansiedad y el rendimiento tiene forma de U invertida; igualmente, si relacionamos población y tiempo la relación será de forma exponencial. En estos casos (y en otros muchos) no es conveniente utilizar la correlación de Pearson. Insistimos en este punto, que parece olvidarse con cierta frecuencia. El coeficiente de correlación de Pearson es un índice de fácil ejecución e, igualmente, de fácil interpretación. Digamos, en primera instancia, que sus valores absolutos oscilan entre 0 y 1.

### Condiciones
* La relación que se quiere estudiar entre ambas variables es lineal (de lo contrario, el coeficiente de Pearson no la puede detectar).
* Las dos variables deben de ser cuantitativas.
* Normalidad: ambas variables se tienen que distribuir de forma normal. Varios textos defienden su robustez cuando las variables se alejan moderadamente de la normal.
* Homocedasticidad: La varianza de Y
* Y debe ser constante a lo largo de la variable X
* X. Esto se puede identificar si en el scatterplot los puntos mantienen la misma dispersión en las distintas zonas de la variable X
* X. Esta condición no la he encontrado mencionada en todos los libros.

### Características
* Toma valores entre [-1, +1], siendo +1 una correlación lineal positiva perfecta y -1 una correlación lineal negativa perfecta.
* Es una medida independiente de las escalas en las que se midan las variables.
* No varía si se aplican transformaciones a las variables.
* No tiene en consideración que las variables sean dependientes o independientes.
* El coeficiente de correlación de Pearson no equivale a la pendiente de la recta de regresión.
* Es sensible a outliers, por lo que se recomienda en caso de poder justificarlos, excluirlos del análisis.

### Interpretación
Además del valor obtenido para el coeficiente, es necesario calcular su significancia. Solo si el p-value es significativo se puede aceptar que existe correlación y esta será de la magnitud que indique el coeficiente. Por muy cercano que sea el valor del coeficiente de correlación a +1 o -1, si no es significativo, se ha de interpretar que la correlación de ambas variables es 0 ya que el valor observado se puede deber al azar. (Ver más adelante como calcular la significancia).
