class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] folders = path.split("/");

        Stack<String> stringStack = new Stack<>();

        for(String folder: folders) {
            if(folder.isBlank() || folder.isEmpty() || folder.equals(".")) continue;

            if(folder.equals("..")) {
                if(!stringStack.empty()) {
                    stringStack.pop();
                }
            } else {
                stringStack.push(folder);
            }
        }
        if(stringStack.empty()) return "/";
        while(!stringStack.empty()) {
            sb.append("/");
            sb.append(stringStack.getFirst());
            stringStack.removeFirst();
        }

        return sb.toString();
    }
}
