#!/bin/bash -e

axe_results_dir="target/test-reports/accessibility-assessment/axe-results"
legacy_axe_results_file="${axe_results_dir}/axeResults.json"
axe_violations_count_file="${axe_results_dir}/axeViolationsCount.json"

if ! command -v jq >/dev/null 2>&1; then
  echo "jq not found; skipping accessibility compatibility file creation."
  exit 0
fi

if [[ ! -d "${axe_results_dir}" ]]; then
  echo "Accessibility results directory ${axe_results_dir} not found."
  exit 0
fi

mapfile -t axe_results_files < <(find "${axe_results_dir}" -mindepth 2 -path "*/axeResults.json" -type f | sort)

if [[ ${#axe_results_files[@]} -eq 0 ]]; then
  echo "No timestamped axeResults.json files found under ${axe_results_dir}."
  exit 0
fi

legacy_axe_results_tmp="$(mktemp)"
axe_violations_count_tmp="$(mktemp)"

jq -s '
  .[0] + {
    inapplicable: [.[].inapplicable[]?],
    incomplete: [.[].incomplete[]?],
    passes: [.[].passes[]?],
    violations: [.[].violations[]?]
  }
' "${axe_results_files[@]}" > "${legacy_axe_results_tmp}"

jq '[.violations[]?] | length' "${legacy_axe_results_tmp}" > "${axe_violations_count_tmp}"

mv "${legacy_axe_results_tmp}" "${legacy_axe_results_file}"
mv "${axe_violations_count_tmp}" "${axe_violations_count_file}"

echo "Created ${legacy_axe_results_file}"
echo "Created ${axe_violations_count_file}"
