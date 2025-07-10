class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0; // To count how many flowers we can place

        // Loop through each plot in the flowerbed
        for(int i = 0; i < flowerbed.length; i++) {
            
            // Check if current plot is empty
            if(flowerbed[i] == 0) {
                // Check left plot
                // If it's the first plot (i == 0), treat left as empty (0)
                int left = (i == 0) ? 0 : flowerbed[i - 1];
                
                // Check right plot
                // If it's the last plot (i == flowerbed.length - 1), treat right as empty (0)
                int right = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

                // If both left and right plots are empty
                if(left == 0 && right == 0) {
                    flowerbed[i] = 1; // Plant a flower here
                    count++;          // Increase the count

                    // If we have placed enough flowers, return true immediately
                    if(count >= n) {
                        return true;
                    }
                }
            }
        }
        // After checking all plots, check if we could place at least n flowers
        return count >= n;
    }
}
