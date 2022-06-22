package com.leetcode.minimum_window_substring;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("a", "a")); // a
        System.out.println(minWindow("a", "aa")); // (empty)
        System.out.println(minWindow("bdab", "ab")); // ab
        System.out.println(minWindow("wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon", "ozgzyywxvtublcl")); // ab
        System.out.println(minWindow("aaflslflsldkalskaaa", "aaa")); // aaa
        System.out.println(minWindow("obzcopzocynyrsgsarijyxnkpnukkrvzuwdjldxndmnvevpgmxrmvfwkutwekrffnloyqnntbdohyfqndhzyoykiripdzwiojyoznbtogjyfpouuxvumtewmmnqnkadvzrvouqfbbdiqremqzgevkbhyoznacqwbhtrcjwfkzpdstpjswnpiqxjhywjanhdwavajrhwtwzlrqwmombxcaijzevbtcfsdcuovckoalcseaesmhrrizcjgxkbartdtotpsefsrjmvksqyahpijsrppdqpvmuocofuunonybjivbjviyftsyiicbzxnwnrmvlgkzticetyfcvqcbjvbufdxgcmesdqnowzpshuwcseenwjqhgsdlxatamysrohfnixfprdsljyyfhrnnjsagtuihuczilgvtfcjwgdhpbixlzmakebszxbhrdibpoxiwztshwczamwnninzmqrmpsviydkptjzpktksrortapgpxwojofxeasoyvyprjoguhqobehugwdvtzlenrcttuitsiijswpogicjolfxhiscjggzzissfcnxnvgftxvbfzkukqrtalvktdjsodmtgzqtuyaqvvrbuexgwqzwduixzrpnvegddyyywaquxjxrnuzlmyipuqotkghfkpknqinoidifnfyczzonxydtqroazxhjnrxfbmtlqcsfhshjrxwqvblovaouxwempdrrplefnxmwrwfjtebrfnfanvvmtbzjesctdgbsfnpxlwihalyiafincfcwgdfkvhebphtxukwgjgplrntsuchyjjuqozakiglangxkttsczhnswjksnuqwflmumpexxrznzwxurrysaokwxxqkrggytvsgkyfjrewrcvntomnoazmzycjrjrqemimyhriyxgrzcfuqtjhvjtuhwfzhwpljzajitrhryaqchnuawbxhxrpvyqcvhpggrpplhychyulijhkglinibedauhvdydkqszdbzfkzbvhldstocgydnbfjkcnkfxcyyfbzmmyojgzmasccaahpdnzproaxnexnkamwmkmwslksfpwirexxtymkmojztgmfhydvlqtddewjvsrmyqjrpycbmndhupmdqqabiuelacuvxnhxgtpvrtwfgzpcrbhhtikbcqpctlxszgpfbgcsbaaiapmtsucocmpecgixshrrnhyrpalralbccnxvjzjllarqhznzghswqsnfuyywmzbopyjyauknxddgdthlabjqtwxpxwljvoxkpjjpfvccyikbbrpdsyvlxscuoofkecwtnfkvcnzbxkeabtdusyhrqklhaqreupakxkfzxgawqfwsaboszvlshwzhosojjotgyagygguzntrouhiweuomqptfjjqsxlbylhwtpssdlltgubczxslqjgxuqnmpynnlwjgmebrpokxjnbiltvbebyytnnjlcwyzignmhedwqbfdepqakrelrdfesqrumptwwgifmmbepiktxavhuavlfaqxqhreznbvvlakzeoomykkzftthoemqwliednfsqcnbexbimrvkdhllcesrlhhjsspvfupxwdybablotibypmjutclgjurbmhztboqatrdwsomnxnmocvixxvfiqwmednahdqhxjkvcyhpxxdmzzuyyqdjibvmfkmonfxmohhshpkhmntnoplphqyprveyfsmsxjfosmicdsjrieeytpnbhlsziwxnpmgoxneqbnufhfwrjbqcsdfarybzwaplmxckkgclvwqdbpumsmqkswmjwnkuqbicykoisqwoootrdpdvcuiuswfqmrkctsgrevcxnyncmivsxbpbxzxpwchiwtkroqisnmrbmefbmatmdknaklpgpyqlsccgunaibsloyqpnsibwuowebomrmcegejozypjzjunjmeygozcjqbnrpakdermjcckartbcppmbtkhkmmtcngteigjnxxyzaibtdcwutkvpwezisskfaeljmxyjwykwglqlnofhycwuivdbnpintuyhtyqpwaoelgpbuwiuyeqhbvkqlsfgmeoheexbhnhutxvnvfjwlzfmvpcghiowocdsjcvqrdmkcizxnivbianfpsnzabxqecinhgfyjrjlbikrrgsbgfgyxtzzwwpayapfgueroncpxogouyrdgzdfucfrywtywjeefkvtzxlwmrniselyeodysirqflpduvibfdvedgcrzpzrunpadvawfsmmddqzaaahfxlifobffbyzqqbtlcpquedzjvykvarayfldvmkapjcfzfbmhscdwhciecsbdledspgpdtsteuafzbrjuvmsfrajtulwirzagiqjdiehefmfifocadxfuxrpsemavncdxuoaetjkavqicgndjkkfhbvbhjdcygfwcwyhpirrfjziqonbyxhibelinpllxsjzoiifscwzlyjdmwhnuovvugfhvquuleuzmehggdfubpzolgbhwyeqekzccuypaspozwuhbzbdqdtejuniuuyagackubauvriwneeqfhtwkocuipcelcfrcjcymcuktegiikyosumeioatfcxrheklookaqekljtvtdwhxsteajevpjviqzudnjnqbucnfvkybggaybebljwcstmktgnipdyrxbgewqczzkaxmeazpzbjsntltjwlmuclxirwytvxgvxscztryubtjweehapvxrguzzsatozzjytnamfyiitreyxmanhzeqwgpoikcjlokebksgkaqetverjegqgkicsyqcktmwjwakivtsxjwrgakphqincqrxqhzbcnxljzwturmsaklhnvyungjrxaonjqomdnxpnvihmwzphkyuhwqwdboabepmwgyatyrgtboiypxfavbjtrgwswyvcqhzwibpisydtmltbkydhznbsvxktyfxopwkxzbftzknnwipghuoijrbgqnzovxckvojvsqqraffwowfvqvfcmiicwitrhxdeombgesxexedlakitfovtydxunqnwqqdeeekiwjnwoshqcsljiicgobbbuqakjdonjawgjlezdnqhfdqnmsuavxdpnfzwipmspiabveaarshzwxmirgkmfncvtdrdvfxkpxlkdokxgtwcskmjryyymcthfnkasinihaunohkxaibtsqelockaefjmsuolebtnepauwmrxutspjwaxbmahsjtkfkxlnszribmeofbkyvbjscjtqjakuwvcgunvnonvqbbggfshauqsyznokqbhowjusypfnecffenojfvlblgzntqzlrgzprvhqnpfrrkzxznieiuivajivzijsqijigtatifmbplzqahuidegfoobpymkputzamzvweiyvvzlwihgmmmrcburbgbsdxrfjsbiylitghgcpqjbevvgypxcybubyoijijrhuzcdijfybqbfowlookqmlnplbxvjjosfqviygqyhgamuwzjklbyzopkrnhbywtfoqomweldmlrhjqswctubiknzzvcztyehouvnyiqnvkufaobehxhrjvtisxjlxoumipzjarwvbsaegdkpbsjmpevjbewzuqnfhoohhmdjgfpmjzdmtmykqvtucptwfidpwtwffzolffzqfdearclkyeecuzabjeqhxpmfodsvisnpxrqowdawheydfyhoexvcmihdlzavtqlshdhdgjzpozvvackebhgqppvcrvymljfvooauxcjnbejdivikcoaugxwzsulgfqdtefpehbrlhaoqxwcancuvbqutnfbuygoemditeagmcveatgaikwflozgdhkyfqmjcruyyuemwbqwxyyfiwnvlmbovlmccaoguieu",
                "cjgamyzjwxrgwedhsexosmswogckohesskteksqgrjonnrwhywxqkqmywqjlxnfrayykqotkzhxmbwvzstrcjfchvluvbaobymlrcgbbqaprwlsqglsrqvynitklvzmvlamqipryqjpmwhdcsxtkutyfoiqljfhxftnnjgmbpdplnuphuksoestuckgopnlwiyltezuwdmhsgzzajtrpnkkswsglhrjprxlvwftbtdtacvclotdcepuahcootzfkwqhtydwrgqrilwvbpadvpzwybmowluikmsfkvbebrxletigjjlealczoqnnejvowptikumnokysfjyoskvsxztnqhcwsamopfzablnrxokdxktrwqjvqfjimneenqvdxufahsshiemfofwlyiionrybfchuucxtyctixlpfrbngiltgtbwivujcyrwutwnuajcxwtfowuuefpnzqljnitpgkobfkqzkzdkwwpksjgzqvoplbzzjuqqgetlojnblslhpatjlzkbuathcuilqzdwfyhwkwxvpicgkxrxweaqevziriwhjzdqanmkljfatjifgaccefukavvsfrbqshhswtchfjkausgaukeapanswimbznstubmswqadckewemzbwdbogogcysfxhzreafwxxwczigwpuvqtathgkpkijqiqrzwugtr")); // aaa
    }

    // TODO: the best solution
    public static String minWindow3(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Long> collectorToCount = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (collectorToCount.containsKey(s.charAt(i))) {
                indexs.add(i);
            }
        }

        String res = null;
        int dst = Integer.MAX_VALUE;
        Map<Character, Long> copy = new HashMap<>();

        for (int index : indexs) {
            copy.clear();
            copy.putAll(collectorToCount);
            for (int i = index; i < s.length(); i++) {
                Character c = s.charAt(i);
                copy.computeIfPresent(c, (k, v) -> --v);
                copy.entrySet().removeIf(v -> v.getValue() == 0);
                if (copy.isEmpty()) {
                    int size = i - index;
                    if (size < dst) {
                        dst = size;
                        res = s.substring(index, i + 1);
                    }
                    break;
                }
            }
        }

        return res == null ? "" : res;
    }

    public static String minWindow2(String s, String t) {
        char[] chars = s.toCharArray();
        List<Character> source = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        List<Character> collect = new ArrayList<>(source);
        Set<Integer> indexes = new HashSet<>();

        int startIdx;
        int indx = -1;
        int counter = 0;

        String res = "";

        for (int i = 0; i < chars.length; i++) {
            Character cursor = s.charAt(i);
            if (t.indexOf(cursor) >= 0) {
                indexes.add(i);
                if (collect.remove(cursor)) {
                    indx = i;
                }
            }

            if (collect.isEmpty()) {
                startIdx = i - counter;
                counter = 0;

                if (indx - startIdx < res.length() || res.length() == 0) {
                    res = s.substring(startIdx, indx + 1);
                }

                collect = new ArrayList<>(source);
                i = Collections.min(indexes);
                indexes.remove(i);
            }

            if (collect.size() != t.length()) {
                counter++;
            }
        }

        return res;
    }

}
