class Solution {
    public String destCity(List<List<String>> paths) {
        // HashMap<String, String> srcDest = new HashMap<>();
        // for(List<String> cities : paths) {
        // srcDest.put(cities.get(0), cities.get(1));
        // if(!srcDest.containsKey(cities.get(1))) {
        // srcDest.put(cities.get(1), null);
        // }
        // }

        // for(String source : srcDest.keySet()) {
        // if(srcDest.get(source) == null) {
        // return source;
        // }
        // }
        // return null;

        HashSet<String> sources = new HashSet<>();

        for (List<String> cities : paths) {
            sources.add(cities.get(0));
        }

        for (List<String> cities : paths) {
            if (!sources.contains(cities.get(1))) {
                return cities.get(1);
            }
        }
        return "";
    }
}