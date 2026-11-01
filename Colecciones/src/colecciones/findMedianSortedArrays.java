package colecciones;

public class findMedianSortedArrays {

    public double medianSorted(int[] nums1, int[] nums2){
        // Aseguramos que nums1 sea el más pequeño (búsqueda binaria más eficiente).
        // Si no lo es, intercambiamos los papeles y volvemos a llamar.
        if(nums1.length > nums2.length){
            return medianSorted(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        // Búsqueda binaria sobre nums1
        while(low <= high){
            // Partición en nums1
            int partitionX = (low + high) / 2;

            // Partición en nums2 tal que izquierda total = derecha total
            int partitionY = (m + n + 1) / 2 - partitionX;

            // Elementos a la izquierda y derecha de cada partición
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // ¿Partición correcta?
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((m + n) % 2 == 0){
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY){
                // Nos pasamos, mover a la izquierda
                high = partitionX - 1;
            } else {
                // Nos quedamos cortos, mover a la derecha
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Los arreglos no están ordenados.");
    }
}
