public interface AllocationRuleService {
    AllocationRule createRule(AllocationRule rule);
    AllocationRule getRule(Long id);
    List<AllocationRule> getAllRules();
}
